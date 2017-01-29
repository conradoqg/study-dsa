/** @namespace BigOFunctions */

/**
 * Function that calculates the powers of 2.
 * 
 * @memberOf BigOFunctions
 * @param {number} n Value of the exponent.
 * @returns Calculation result. 
 */
function powers0f2(n) {
    this.step();
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
 *   
 * @memberOf BigOFunctions
 */
function O1Simple() {
    this.step();
}

/**
 * Simple function that executes one statement per array item.
 *   
 * @memberOf BigOFunctions
 * @param {array} array to loop trought.
 */
function ONSimple(array) {
    array.forEach(() => this.step());
}

/**
 * Simple function that executes one statement in a m * n combination.
 *   
 * @memberOf BigOFunctions
 * @param {array} array to loop trought. 
 */
function ON2Simple(array) {
    array.forEach(() => {
        array.forEach(() => this.step());
    });
}

/**
 * Simple function that executes one statement every 2 * n combination.
 *    
 * @memberOf BigOFunctions
 * @param {number} n Number of times to duplicate execution.
 */
function O2NSimple(n) {
    if (n >= 1) {
        O2NSimple.apply(this, [n - 1]) + O2NSimple.apply(this, [n - 1]);
    } else {
        this.step();
    }
}

/**
 * Function that calculates a fibonacci number.
 *    
 * @memberOf BigOFunctions
 * @param {number} n Number to calculate fibonacci.
 */
function fibonacci(n) {
    if (n <= 0) {
        this.step();
        return 0;
    } else if (n == 1) {
        this.step();
        return 1;
    }
    return fibonacci.apply(this, [n - 1]) + fibonacci.apply(this, [n - 2]);
}

module.exports = {
    powers0f2,
    O1Simple,
    ONSimple,
    ON2Simple,
    O2NSimple,
    fibonacci
};