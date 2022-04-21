let s = "abbbcacbcdce";
let maxDeviation = 0;
for (let i = 1; i < s.length; i++) {
  let map = new Map();
  let min = Number.MAX_VALUE;
  let max = Number.MIN_VALUE;
  for (let j = 0; j < i; j++) {
    if (map.get(s[j]) == undefined) {
      map.set(s[j], 1);
    } else {
      map.set(s[j], map.get(s[j]) + 1);
    }
    min = Math.min(min, map.get(s[j]));
    max = Math.max(max, map.get(s[j]));
  }
  maxDeviation = Math.max(maxDeviation, max - min);
}
