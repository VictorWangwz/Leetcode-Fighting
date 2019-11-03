var reverseString = function(s) {
    s = s.split("").reverse().join("");
    return s;

}

let s = "good";
let rst = reverseString(s);
console.log(rst);