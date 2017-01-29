const perfy = require('perfy');
const R = require('ramda');

/**
 * Provides functionality to instrument and measure function calls.
 * 
 * @class Instrumentation
 */
class Instrumentation {
    constructor() {
        this.measurements = [];
    }

    
    /**
     * Wrap a function for measurement.
     * 
     * @param {function} fn Function to be wrapped.     
     * @returns Function that wraps the original and do measurement.
     * 
     * @example
     * // Warp a function and then call it:
     * const wrappedFunction = instrumentation.wrapForMeasurement(function(number) { console.log(number) });
     * wrappedFunction(1);     
     * 
     * @memberOf Instrumentation
     */
    wrapForMeasurement(fn) {        
        return function (...args) {            
            let measurement = {
                name: fn.name,
                args: args,
                steps: 0,
                argsSize: 0,
                duration: 0,
            };

            let instrument = {
                step: function () {
                    measurement.steps++;
                }
            };
            measurement.argsSize = Instrumentation.calculateArgs(args);
            measurement.duration = perfy.exec(() => { fn.apply(instrument, args); }).milliseconds;
            return measurement;
        };
    }


    /**
     * Run a function n times with m different parameter and take measurement.
     * 
     * @param {function} fn Function to be run.
     * @param {number} samplesAmount Amount of samples to take measurement.
     * @param {array} args Array of arrays with the each parameter combination to call each function.
     * 
     * @example
     * // Take 10 measurements for each parameter combination [100,200], [200,400], [400,800]
     * instrumentation.measure((m,n) => { console.log(m*n) }), 10, [[100, 200], [200, 400], [400, 800]]);
     * 
     * @memberOf Instrumentation
     */
    measure(fn, samplesAmount, args) {
        const ignoreFirst = 4;
        const self = this;        
        
        let argsMeasurements = args.map(arg => {
            let measurements = [];
            for (var index = 0; index < samplesAmount + ignoreFirst; index++) {
                const measurement = this.wrapForMeasurement(fn)(...arg);
                if (!(index < ignoreFirst ? true : false)) self.measurements.push(measurement);
                measurements.push(measurement);                
            }            
            
            return R.assoc('duration', R.mean(R.map(measurement => measurement.duration, measurements)), R.head(measurements));         
        });

        return argsMeasurements;
    }

    /**
     * Calculates the average duration by call group (function name + args).
     * 
     * @returns Object with each item containing the average duration.
     * 
     * @memberOf Instrumentation
     */
    averageDurationByCallGroup() {
        let groupedByCallAndArgs = R.groupBy(measurement => { return measurement.name + measurement.args; }, this.measurements);        
        let averageDurationByCallGroup = R.map(i => {            
            return R.assoc('duration', R.mean(R.map(x => x.duration, i)), R.head(i));
        }, groupedByCallAndArgs);

        return averageDurationByCallGroup;
    }    

    /**
     * Calculate the total argument count, usefull to find the closest Big O notation.
     * 
     * @private
     * @static
     * @param {any} args Arguments to calculate.
     * @returns Sum of the provided arguments.
     * 
     * @memberOf Instrumentation
     */
    static calculateArgs(args) {
        return R.sum(R.map((arg) => {
            if (typeof (arg) == 'number') {
                return arg;
            } else if (Array.isArray(arg)) {
                return arg.length;
            } else if (typeof (arg) == 'string') {
                return arg.length;
            } else {
                return 0;
            }            
        }, args));        
    }    
}

module.exports = Instrumentation;