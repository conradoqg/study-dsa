const Instrumentation = require('../src/instrumentation.js');
const findBigO = require('../src/findBigO.js');
const bigOFunctions = require('../src/bigOFunctions.js');
const util = require('util');
const assert = require('assert');
const R = require('ramda');

const print = function (description, measurement) { console.log('\t' + description + util.inspect(measurement, { breakLength: Infinity, depth: 1, colors: true })); };

const printMeasurementAndFoundBigOs = function (measurements, foungBigOs) {    
    console.log('');

    for (var index = 0; index < measurements.length; index++) {        
        print('Result: ', measurements[index]);
        print('Big O: ', foungBigOs[index]);
    }    
    console.log('');
};

describe('Big O Notation', () => {
    it('O(log N) Power of 2', () => {
        const instrumentation = new Instrumentation();
        const measurements = instrumentation.measure(bigOFunctions.powers0f2, 10, [{ n: 5 }, { n: 10 }, { n: 20 }]);
        const foundBigOs = findBigO.findBigOs(measurements);

        printMeasurementAndFoundBigOs(measurements, foundBigOs);

        assert(R.last(foundBigOs).n.name == 'O(log N)');
    });

    it('O(1) Simple', () => {
        const instrumentation = new Instrumentation();
        const measurements = instrumentation.measure(bigOFunctions.O1Simple, 10, [{ n: 100, m: 200 }, { n: 200, m: 400 }, { n: 400, m: 800 }]);
        const foundBigOs = findBigO.findBigOs(measurements);

        printMeasurementAndFoundBigOs(measurements, foundBigOs);

        assert(R.last(foundBigOs).n.name == 'O(1)');
        assert(R.last(foundBigOs).m.name == 'O(1)');
    });

    it('O(N) Simple', () => {
        const instrumentation = new Instrumentation();
        const measurements = instrumentation.measure(bigOFunctions.ONSimple, 10, [{ array: new Array(100).fill(0) }, { array: new Array(200).fill(0) }, { array: new Array(400).fill(0) }]);
        const foundBigOs = findBigO.findBigOs(measurements);

        printMeasurementAndFoundBigOs(measurements, foundBigOs);

        assert(R.last(foundBigOs).array.name == 'O(N)');
    });

    it('O(N^2) Simple', () => {
        const instrumentation = new Instrumentation();
        const measurements = instrumentation.measure(bigOFunctions.ON2Simple, 10, [{ array: new Array(100).fill(0) }, { array: new Array(200).fill(0) }, { array: new Array(400).fill(0) }, { array: new Array(800).fill(0) }, { array: new Array(1600).fill(0) }]);
        const foundBigOs = findBigO.findBigOs(measurements);

        printMeasurementAndFoundBigOs(measurements, foundBigOs);

        assert(R.last(foundBigOs).array.name == 'O(N^2)');        
    });

    it('O(2^N) Simple', () => {
        const instrumentation = new Instrumentation();
        const measurements = instrumentation.measure(bigOFunctions.O2NSimple, 10, [{ n: 5 }, { n: 10 }, { n: 20 }]);
        const foundBigOs = findBigO.findBigOs(measurements);

        printMeasurementAndFoundBigOs(measurements, foundBigOs);

        assert(R.last(foundBigOs).n.name == 'O(2^N)');
    });

    it('O(2^N) Fibonacci', () => {
        const instrumentation = new Instrumentation();
        const measurements = instrumentation.measure(bigOFunctions.fibonacci, 10, [{ n: 5 }, { n: 10 }, { n: 20 }, { n: 30 }]);
        const foundBigOs = findBigO.findBigOs(measurements);

        printMeasurementAndFoundBigOs(measurements, foundBigOs);

        assert(R.last(foundBigOs).n.name == 'O(2^N)');
    });

    it('O(A + B) Simple', () => {
        const instrumentation = new Instrumentation();
        const measurements = instrumentation.measure(bigOFunctions.OADBSimple, 10, [{ arrayA: Array(100).fill(0), arrayB: Array(100).fill(0) }, { arrayA: Array(200).fill(0), arrayB: Array(200).fill(0) }]);
        const foundBigOs = findBigO.findBigOs(measurements, [{ left: 'arrayA', operation: '+', right: 'arrayB' }]);

        printMeasurementAndFoundBigOs(measurements, foundBigOs);

        assert(R.last(foundBigOs).arrayA.name == 'O(N)');
        assert(R.last(foundBigOs).arrayB.name == 'O(N)');        
    });

    it('O(A * B) Simple', () => {
        const instrumentation = new Instrumentation();
        const measurements = instrumentation.measure(bigOFunctions.ONXNSimple, 10, [{ arrayA: Array(100).fill(0), arrayB: Array(100).fill(0) }, { arrayA: Array(200).fill(0), arrayB: Array(200).fill(0) }, { arrayA: Array(500).fill(0), arrayB: Array(500).fill(0) }]);
        const foundBigOs = findBigO.findBigOs(measurements, [{ left: 'arrayA', operation: '*', right: 'arrayB' }]);

        printMeasurementAndFoundBigOs(measurements, foundBigOs);

        assert(R.last(foundBigOs).arrayA.name == 'O(N)');
        assert(R.last(foundBigOs).arrayB.name == 'O(N)');
    });
});
