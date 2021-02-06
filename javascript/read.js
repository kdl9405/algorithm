
let N; // 정수를 저장할 변수
rl.on("line", function(line){
    console.log(`print input string ${line}`);
    N = Number(line);
    console.log(`print input number ${N}`);
    rl.close();
})