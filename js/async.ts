let a = 10;
const plus = (a) => a = a+10;
async function f() {
    a = await plus(a);
    console.log("async " + a);
    return a;
}
f().then( val => console.log(val));
let p = new Promise((resolve, reject) => resolve(1))
.then((val) => console.log("promise then")).catch(error => console.log(err));





// class Sleep {
//     constructor(timeout) {
//       this.timeout = timeout;
//     }
//     then(resolve, reject) {
//       const startTime = Date.now();
//       setTimeout(
//         () => resolve(Date.now() - startTime),
//         this.timeout
//       );
//     }
//   }
  
//   (async () => {
//     const sleepTime = await new Sleep(1000);
//     console.log(sleepTime);
//   })();

  // function sleep(interval) {
  //   return new Promise(resolve => {
  //       const startTime = Date.now();
  //          setTimeout(
  //            () => resolve(Date.now() - startTime),
  //           interval
  //          );
  //   })
  // }
  // async function one2FiveInAsync() {
  //   for(let i = 1; i <= 5; i++) {
  //     console.log(i);
  //     const rst = await sleep(1000);
  //     console.log(rst);
  //   }
  //   return "good";
  // }
  
  // one2FiveInAsync().then(val => {console.log(val)});
  console.log("normal"+a);

  let prom = new Promise(resolve => {console.log("resolve"); resolve()});

  class Test{
    static print1(){
      console.log("static");
    }
    print2(){
      console.log("nonstatic");
    }
  }

  let test = new Test();
  Test.print1();

  async function getUrl(urls){
      const promises = urls.map(async url => {
        const rsp = await fetch(url);
        return rsp;
      });
      const rsts = [];
      for(let promise of promises){
        rsts.push(await promise);
      }
      return rsts;
  }

  // const rst = getUrl(["https://google.com"]);
  // console.log(rst);


// const getJson = function(url){
//   return new Promise((resolve, reject) => {
//     const handler = function(){
//       if(this.readyState != 4){
//         return;
//       }
//       if(this.status == 200){
//         resolve(this.response);
//       }
//       else{
//         reject(new Error(this.statusText));
//       }
//     };
//     const xhr = new XMLHttpRequest();
//     xhr.open("GET", url);
//     xhr.onreadystatechange = handler;
//     xhr.responseType = "json";
//     xhr.setRequestHeader("Accept", "application/javascript");
//     xhr.send();
//   })
// }

// getJson("https://google.com");

var x = 1;
switch(x){
  case 1,2,3:{
    console.log("hah");
    break;
  }
  default: {
    console.log("default");
  }
}


for(var i = 0; i < 5; i++){
  setTimeout(function(){console.log(i);}, 1000);
}
console.log(i);

