/** @namespace BigOFunctions */

/**
 * Function that calculates the powers of 2.
 * Big O: O(log N)
 * 
 * @memberOf BigOFunctions
 * @param {number} n Value of the exponent.
 * @returns Calculation result. 
 */
function powers0f2(n) {
    this.step('n');
    if (n < 1) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        let prev = powers0f2.apply(this, [n / 2]);
        let curr = prev * 2;
        return curr;
    }
}

/**
 * Simple function that executes only one statement.
 * Big O: O(1)
 *   
 * @memberOf BigOFunctions
 * @param {number} n First number
 * @param {number} m Second number
 * @returns Multipliation of n by m
 */
function O1Simple(n, m) {
    this.step('n', 'm');
    return n * m;
}

/**
 * Simple function that executes one statement per array item.
 * Big O: O(N)
 *   
 * @memberOf BigOFunctions
 * @param {array} array to loop trought.
 */
function ONSimple(array) {
    array.forEach(() => this.step('array'));
}

/**
 * Simple function that executes one statement in a m * n combination.
 * Big O: O(N^2)
 *   
 * @memberOf BigOFunctions
 * @param {array} array to loop trought. 
 */
function ON2Simple(array) {
    array.forEach(() => {
        array.forEach(() => this.step('array'));
    });
}

/**
 * Simple function that executes one statement every 2 * n combination.
 * Big O: O(2^N)
 *    
 * @memberOf BigOFunctions
 * @param {number} n Number of times to duplicate execution.
 */
function O2NSimple(n) {
    this.step('n');
    if (n <= 1) {
        return 1;
    }
    O2NSimple.apply(this, [n - 1]) + O2NSimple.apply(this, [n - 1]);
}

/**
 * Function that calculates a fibonacci number.
 * Big O: O(2^N)
 *    
 * @memberOf BigOFunctions
 * @param {number} n Number to calculate fibonacci.
 */
function fibonacci(n) {
    this.step('n');
    if (n <= 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    }
    return fibonacci.apply(this, [n - 1]) + fibonacci.apply(this, [n - 2]);
}

/**
 * Simple function that has two sequencial array loops.
 * Big O: O(A + B)
 * 
 * @memberOf BigOFunctions
 * @param {array} arrayA First array.
 * @param {array} arrayB Second array.
 */
function OADBSimple(arrayA, arrayB) {
    arrayA.forEach(() => {
        this.step('arrayA');
    });

    arrayB.forEach(() => {
        this.step('arrayB');
    });
}

/**
 * Simple function that has an array loop inside other array loop.
 * Big O: O(A * B)
 * 
 * @memberOf BigOFunctions
 * @param {array} arrayA First array.
 * @param {array} arrayB Second array.
 */
function ONXNSimple(arrayA, arrayB) {
    arrayA.forEach(() => {
        this.step('arrayA');
        arrayB.forEach(() => {
            this.step('arrayB');
        });        
    });    
}

/**
 * Simple function that has an array loop inside other array loop. The inner loop does half of the work of the outer loop
 * Big O: O(N * N/2) = O(N^2)
 * 
 * @memberOf BigOFunctions
 * @param {array} array array. 
 */
function ON2HalfInnerLoop(array) {
    for (let i= 0; i < array.length; i++) { // N work        
        for (let j = i + 1; j < array.length; j++) { // N/2 work (on average)            
        }
    }
}

module.exports = {
    powers0f2,
    O1Simple,
    ONSimple,
    ON2Simple,
    O2NSimple,
    fibonacci,
    OADBSimple,
    ONXNSimple,
    ON2HalfInnerLoop
};