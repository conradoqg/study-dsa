
/**
 * Calculates a factorial number.
 * 
 * @private
 * @param {number} num Number to be calculated.
 * @returns Factorial number.
 */
function sFact(num)
{
    var rval=1;
    for (var i = 2; i <= num; i++)
        rval = rval * i;
    return rval;
}


/**
 * Find the closest Big O notation according to argument size and the amout os steps taken.
 * 
 * @param {number} argsSize Total number of arguments.
 * @param {any} steps Total amount of steps taken.
 * @returns Object containing the Big O notation name and max steps.
 */
function findBigO(argsSize, steps) {
    const commonBigONotation = [
        { name: 'O(log N)', value: argsSize/2},
        { name: 'O(1)', value: 1},
        { name: 'O(N)', value: argsSize},
        { name: 'O(N log N)', value: argsSize * ((argsSize/2) + 1)},
        { name: 'O(N^2)', value: Math.pow(argsSize, 2)},
        { name: 'O(2^N)', value: Math.pow(2, argsSize)},
        { name: 'O(N!)', value: sFact(argsSize)}
    ];
    
    let distance = (numberA, numberB) => { return numberB - numberA; };
    let calculatedDistances = commonBigONotation.map((point) => { return distance(steps, point.value); });    
    let closestPoint = calculatedDistances.reduce((calculatedDistancesA, calculatedDistancesB) => {         
        calculatedDistancesA = (calculatedDistancesA < 0 ? Infinity : calculatedDistancesA);
        calculatedDistancesB = (calculatedDistancesB < 0 ? Infinity : calculatedDistancesB);
        return Math.min(calculatedDistancesA, calculatedDistancesB);        
    });
    return commonBigONotation[calculatedDistances.indexOf(closestPoint)];
}

module.exports = findBigO;