const R = require('ramda');

/**
 * Calculates a factorial number.
 * 
 * @private
 * @param {number} num Number to be calculated.
 * @returns Factorial number.
 */
function sFact(num) {
    var rval = 1;
    for (var i = 2; i <= num; i++)
        rval = rval * i;
    return rval;
}

/**
 * Calculates the arg size according to the arg type.
 * 
 * @private
 * @param {any} arg Argument.
 * @returns Argument size.
 */
function calculateArgSize(arg) {
    if (typeof (arg) == 'number') {
        return arg;
    } else if (Array.isArray(arg)) {
        return arg.length;
    } else if (typeof (arg) == 'string') {
        return arg.length;
    } else {
        return 0;
    }
}

/**
 * Creates the big O notation according the argument size provided.
 * 
 * @private
 * @param {number} argSize Argument size.
 * @returns Object with the common big O notation and its respective values according the argument size.
 */
function createBigONotation(argSize) {
    return [
        { name: 'O(log N)', value: (argSize / 2) },
        { name: 'O(1)', value: 1 },
        { name: 'O(N)', value: argSize },
        { name: 'O(N log N)', value: argSize * ((argSize / 2) + 1) },
        { name: 'O(N^2)', value: Math.pow(argSize, 2) },
        { name: 'O(2^N)', value: Math.pow(2, argSize) },
        { name: 'O(N!)', value: sFact(argSize) }
    ];
}

/**
 * Find the lower closest common big o notation given the steps provided.
 * 
 * @private
 * @param {object} bigONotation Commom Big O notations created from a argument size.
 * @param {number} steps Steps taken for a certain argument.
 * @return Big O notation found.
 */
function getClosestBigOFor(bigONotation, steps) {
    const distance = (numberA, numberB) => { return numberB - numberA; };
    const calculatedDistances = bigONotation.map((point) => { return distance(steps, point.value); });
    const closestPoint = calculatedDistances.reduce((calculatedDistancesA, calculatedDistancesB) => {
        calculatedDistancesA = (calculatedDistancesA < 0 ? Infinity : calculatedDistancesA);
        calculatedDistancesB = (calculatedDistancesB < 0 ? Infinity : calculatedDistancesB);
        return Math.min(calculatedDistancesA, calculatedDistancesB);
    });
    return bigONotation[calculatedDistances.indexOf(closestPoint)];
}


/**
 * Find the closest Big O notation according to a objecy list of argument size and the amout os steps taken.
 * 
 * @param {object} args Total number of arguments.
 * @param {any} steps Total amount of steps taken.
 * @param {object} relation The relation between the arguments.
 * @returns Object containing a list of the Big O notation name and max steps fund for every argument.
 */
function findBigO(args, steps, relation) {
    let foundBigOs = {};

    // Calculate values for keys
    R.forEach(argsKey => {
        const argSize = calculateArgSize(args[argsKey]);

        let resolvedSteps = steps[argsKey];
        if (relation != null) {
            const foundRelation = R.find(R.propEq('right', argsKey))(relation);

            if (foundRelation != null) {
                if (foundRelation.operation == '*') {
                    resolvedSteps = steps[argsKey] / steps[foundRelation.left];
                }
            }
        }
        const bigONotation = createBigONotation(argSize);
        const foundBigO = getClosestBigOFor(bigONotation, resolvedSteps);
        foundBigOs[argsKey] = foundBigO;
    }, R.keys(args));

    return foundBigOs;
}

module.exports = findBigO;