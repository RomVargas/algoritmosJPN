function apartmentHunting(blocks, reqs) {
	const maxDistancesAtBlocks = new Array(blocks.length).fill(-Infinity);
	for(let i = 0; i < blocks.length; i++) {
		for (const req of reqs) {
			let closestReqDistance = Infinity;
			for (let j = 0; j < blocks.length; j++) {
				if (blocks[j][req]) {
					closestReqDistance = Math.min(closestReqDistance, distanceBetween(i, j));
				}
			}
			maxDistancesAtBlocks[i] = Math.max(maxDistancesAtBlocks[i], closestReqDistance);
		}
	}
	return getIdxAtMinValue(maxDistancesAtBlocks);
}

function getIdxAtMinValue(array) {
	let idxAtMinValue = 0;
	let minValue = Infinity;
	for(let i = 0; i < array.length; i++){
		const currentValue = array[i];
		if (currentValue < minValue) {
			minValue = currentValue;
			idxAtMinValue = i;
		}
	}
	return idxAtMinValue;
}

function distanceBetween(a, b) {
	return Math.abs(a - b);
}

// Do not edit the line below.
exports.apartmentHunting = apartmentHunting;

const blocks = [
    {
      gym: false,
      school: true,
      store: false,
    },
    {
      gym: true,
      school: false,
      store: false,
    },
    {
      gym: true,
      school: true,
      store: false,
    },
    {
      gym: false,
      school: true,
      store: false,
    },
    {
      gym: false,
      school: true,
      store: true,
    },
  ];
const reqs = ['gym', 'school', 'store'];