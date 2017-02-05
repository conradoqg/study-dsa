/** 
 * @namespace BigOFunctions 
 * @description
 * Concepts:
 * - Drop constants
 *  - O(2N) = O(N)
 * - Drop non-dominant terms
 *  - O(N^2 + N) = O(N^2)
 *  - O(N + log N) = O(N)
 *  - 0(5*2^N + 1000N^100 ) = O(2^N)
 * - Multi-part algorithms
 *  - Add
 *      - A chunks of work then B chunks of work is O(A+B)
 *  - Multiply
 *      - B chunks of work every A element is I(A*B)
 **/

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
        let prev = powers0f2.apply(this, [n / 2]); // every recursive call does N/2, so log N 
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
    return n * m; // 1 work
}

/**
 * Simple function that executes one statement per array item.
 * Big O: O(N)
 *   
 * @memberOf BigOFunctions
 * @param {array} array to loop trought.
 */
function ONSimple(array) {
    array.forEach(() => this.step('array')); // N work
}

/**
 * Simple function that executes one statement in a m * n combination.
 * Big O: O(N^2)
 *   
 * @memberOf BigOFunctions
 * @param {array} array to loop trought. 
 */
function ON2Simple(array) {
    array.forEach(() => { // N work
        array.forEach(() => this.step('array')); // N work
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
    O2NSimple.apply(this, [n - 1]) + O2NSimple.apply(this, [n - 1]); // branches^N = 2^N work
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
    return fibonacci.apply(this, [n - 1]) + fibonacci.apply(this, [n - 2]); // branches^N = 2^N work
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
        this.step('arrayA'); // A work
    });

    arrayB.forEach(() => {
        this.step('arrayB'); // B work
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
    arrayA.forEach(() => { // A work
        this.step('arrayA');
        arrayB.forEach(() => { // B work
            this.step('arrayB');
        });
    });
}

/**
 * Simple function that has an array loop inside other array loop. The inner loop does half of the work of the outer loop
 * Big O: O(N * N/2) = O((N^2)/2) = O(N^2)
 * 
 * @memberOf BigOFunctions
 * @param {array} array array. 
 */
function ON2HalfInnerLoop(array) {
    for (let i = 0; i < array.length; i++) { // N work        
        for (let j = i + 1; j < array.length; j++) { // N/2 work (on average)                        
        }
    }
}

/**
 * Simple function that has an array loop, the loop is array size / 2.
 * Big O: O(N)
 * 
 * @memberOf BigOFunctions
 * @param {array} array array. 
 */
function reverse(array) {
    for (let i = 0; i < array.length / 2; i++) { // It does N even though is array / 2. array / 2 is the N work.
        let other = array.length - i - 1;
        let temp = array[i];
        array[i] = array[other];
        array[other] = temp;
    }
}

/**
 * 2^log N example.
 * Big O: O(N)
 * 
 * @memberOf BigOFunctions
 * @param {object} node object which is a balanced binary tree.
 * @returns sum of all nodes.
 */
function sum(node) {
    if (node == null) {
        return 0;
    }
    return sum(node.left) + node.value + sum(node.right); // 2^log N work = O(N) which 2^depth but each recursive call does log N work.
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