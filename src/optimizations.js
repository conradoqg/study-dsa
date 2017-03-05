/**
 * Find all positive integer solutions to the equation a^3 + b^3 = c^3 + d^3 where a, b, c and d are integers between 1 and <maxValue>.
 **/

function equationBruteForce(maxValue) {
    const n = maxValue;
    let equations = [];

    for (let a = 1; a <= n; a++) {
        for (let b = 1; b <= n; b++) {
            for (let c = 1; c <= n; c++) {
                for (let d = 1; d <= n; d++) {
                    if (Math.pow(a, 3) + Math.pow(b, 3) === Math.pow(c, 3) + Math.pow(d, 3)) {
                        equations.push({ a, b, c, d });
                    }
                }
            }
        }
    }

    return equations;
}

function equationUnnecessary(maxValue) {
    const n = maxValue;
    let equations = [];

    for (let a = 1; a <= n; a++) {
        for (let b = 1; b <= n; b++) {
            for (let c = 1; c <= n; c++) {
                const a3 = Math.pow(a, 3);
                const b3 = Math.pow(b, 3);
                const c3 = Math.pow(c, 3);
                const d3 = a3 + b3 - c3;
                const d = Math.cbrt(d3);
                if (d > 0 && d <= maxValue && Number.isInteger(d)) {
                    if (a3 + b3 === c3 + d3) {
                        equations.push({ a, b, c, d });
                    }
                }
            }
        }
    }

    return equations;
}

function equationDuplicatedWork(maxValue) {
    const n = maxValue;
    let cdPairs = new Map();
    let equations = [];

    for (let c = 1; c <= n; c++) {
        for (let d = 1; d <= n; d++) {
            const c3 = Math.pow(c, 3);
            const d3 = Math.pow(d, 3);

            let pairList = [];
            if (cdPairs.has(c3 + d3)) pairList = cdPairs.get(c3 + d3);

            pairList.push({ c, d });
            cdPairs.set(c3 + d3, pairList);
        }
    }

    for (let a = 1; a <= n; a++) {
        for (let b = 1; b <= n; b++) {
            const a3 = Math.pow(a, 3);
            const b3 = Math.pow(b, 3);
            if (cdPairs.has(a3 + b3)) {
                let cbPairsFromResult = cdPairs.get(a3 + b3);
                for (var index = 0; index < cbPairsFromResult.length; index++) {
                    var equation = cbPairsFromResult[index];
                    equation.a = a;
                    equation.b = b;
                    equations.push(equation);
                }
            }
        }
    }

    return equations;
}

module.exports = {
    equationBruteForce,
    equationUnnecessary,
    equationDuplicatedWork
};