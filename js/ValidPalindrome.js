var isPalindrome = function(s) {
    let l = 0;
    s = s.replace(/\W/g, '').toLowerCase();
    let r = s.length - 1;
    while( l <= r ){
        if(s[l] != s[r]){
            return false;
        }
        l++;
        r--;
    }
    return true;
};

console.log(isPalindrome("A man, a plan, a canal: Panama"));