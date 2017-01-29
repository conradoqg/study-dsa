const Instrumentation = require('../src/instrumentation.js');
const findBigO = require('../src/findBigO.js');
const bigOFunctions = require('../src/bigOFunctions.js');
const util = require('util');

const printMeasurement = function (description, measurement) { console.log('\t' + description + util.inspect(measurement, { breakLength: Infinity, depth: 1, colors: true })); };

const defaultBigONotationTest = function (fn, args) {
    let instrumentation = new Instrumentation();
    let measurements = instrumentation.measure(fn, 10, args);

    console.log('');
    measurements.forEach(measurement => {
        printMeasurement('Result: ', measurement);
        printMeasurement('Big O: ', findBigO(measurement.argsSize, measurement.steps));
    });
    console.log('');
};

describe('Big O Notation', () => {    

    it('O(log N) Power of 2', () => {
        return defaultBigONotationTest(bigOFunctions.powers0f2, [[5], [10], [20], [50]]);
    });
    
    it('O(1) Simple', () => {
        return defaultBigONotationTest(bigOFunctions.O1Simple, [[100, 200], [200, 400], [400, 800]]);
    });
    
    it('O(N) Simple', () => {
        return defaultBigONotationTest(bigOFunctions.ONSimple, [[new Array(100).fill(0)], [new Array(200).fill(0)], [new Array(400).fill(0)]]);                        
    });
    
    it('O(N^2) Simple', () => {
        return defaultBigONotationTest(bigOFunctions.ON2Simple, [[new Array(100).fill(0)], [new Array(200).fill(0)], [new Array(400).fill(0)], [new Array(800).fill(0)], [new Array(1600).fill(0)]]);
    });

    it('O(2^N) Simple',() => {
        return defaultBigONotationTest(bigOFunctions.O2NSimple, [[5], [10], [20]]);                
    });

    it('O(2^N) Fibonacci', () => {
        return defaultBigONotationTest(bigOFunctions.fibonacci, [[5], [10], [20], [30]]);                
    });    
});
