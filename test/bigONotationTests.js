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
        for (let key in measurement.steps) {
            printMeasurement('Big O for ' + key + ': ', findBigO(measurement.argsSize[key], measurement.steps[key]));
        }        
    });
    console.log('');
};

describe('Big O Notation', () => {

    it('O(log N) Power of 2', () => {
        return defaultBigONotationTest(bigOFunctions.powers0f2, [{ n: 5 }], [{ n: 10 }], [{ n: 20 }], [{ n: 50 }]);
    });

    it('O(1) Simple', () => {
        return defaultBigONotationTest(bigOFunctions.O1Simple, [{ n: 100, m: 200 }, { n: 200, m: 400 }, { n: 400, m: 800 }]);
    });

    it('O(N) Simple', () => {
        return defaultBigONotationTest(bigOFunctions.ONSimple, [{ array: new Array(100).fill(0) }, { array: new Array(200).fill(0) }, { array: new Array(400).fill(0) }]);
    });

    it('O(N^2) Simple', () => {
        return defaultBigONotationTest(bigOFunctions.ON2Simple, [{ array: new Array(100).fill(0) }, { array: new Array(200).fill(0) }, { array: new Array(400).fill(0) }, { array: new Array(800).fill(0) }, { array: new Array(1600).fill(0) }]);
    });

    it('O(2^N) Simple', () => {
        return defaultBigONotationTest(bigOFunctions.O2NSimple, [{ n: 5 }, { n: 10 }, { n: 20 }]);
    });

    it('O(2^N) Fibonacci', () => {
        return defaultBigONotationTest(bigOFunctions.fibonacci, [{ n: 5 }, { n: 10 }, { n: 20 }, { n: 30 }]);
    });
});
