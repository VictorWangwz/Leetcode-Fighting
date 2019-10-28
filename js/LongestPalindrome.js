var longestPalindrome = function(s) {
    let dict = {}
    for(let i = 0; i < s.length; i++){
        if(!dict[s[i]] ){
            dict[s[i]] = 0;
        }
        dict[s[i]] ++;
    }
    let rst = 0;
    let flag = false;
   Object.keys(dict).forEach(key => {
        value = dict[key];
        rst += Math.floor(value /2) * 2;
        if(value % 2 == 1){
            flag = true;
        }

   })
    return flag? rst + 1: rst;
};

console.log(longestPalindrome("abccccdd"));