const assert = require('assert');
const optimizations = require('../src/optimizations.js');


describe('Equation Optmization.', () => {
    it('should find solutions using brute force.', () => {      
        const equations = optimizations.equationBruteForce(100);

        assertEquationFor100(equations);        
    });

    it('should find solutions removing unnecessary work.', () => {
        const equations = optimizations.equationUnnecessary(100);

        assertEquationFor100(equations);
    });

    it('should find solutions removing duplicated work.', () => {
        const equations = optimizations.equationDuplicatedWork(100);

        assertEquationFor100(equations);
    });
});

function assertEquationFor100(equations) {
    const expectedResultsCount = 20260;
    assert.ok(equations instanceof Array, 'The equations isn\'t an array.');
    assert.equal(equations.length, expectedResultsCount, 'The array lenght should be equal to ' + expectedResultsCount + '.');

    const randomResult = equations[getRandomInt(1, expectedResultsCount)];
    assert.equal(Math.pow(randomResult.a, 3) + Math.pow(randomResult.b, 3), Math.pow(randomResult.c, 3) + Math.pow(randomResult.d, 3), 'The a^3+b^3 should be equal to c^3+d^3 from a random result.');
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}