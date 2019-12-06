const countWordsInParagraph = paragraph => {
    const dict = {};
    const wordArr = paragraph.match(/[A-Za-z0-9]+/g);
    // const wordArr = paragraph.split('.').join('').split('?').join('').split(' ');
    console.log(wordArr);
    for(const word of wordArr){
        if(!word in dict){
            dict[word] = 0;
        }
        dict[word] ++;
    }
    return wordArr;
}


const paragraph = "Matches beginning of input_?.990     If the multiline flag is set to true, also matches immediately\nafter a line break character.";
console.log(paragraph);
const rst = countWordsInParagraph(paragraph);
console.log(rst);