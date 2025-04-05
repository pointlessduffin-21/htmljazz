var realConsoleLog = console.log;
console.log = function () {
var message = [].join.call(arguments, " ");
$(".output").text(message);
realConsoleLog.apply(console, arguments);
};


function myFunction1() {
    var user={"name":"Joel0437", "age":"25", "Country":"Australia"};
    console.log("Name:", user["name"], "Age:", user["age"], "Country:", user["Country"]);
}

function myFunction2() {
    let marks = prompt("Please enter your grade");
    if (marks>80){
        console.log("Score:", marks, "(","Excellent",")");
    }else if(marks<=80 && marks>70){
        console.log(", Good Job!");
    }else if(marks>=70 && marks<60){
        console.log("Better luck next time");
    }else{
       console.log("Work harder next time!");
    }
}

function prompt() {
    for (var i=0; i<5; i++){
        console.log(i);
    }
    while(i<5){
        console.log(i);
        i=i+1;
    }
}

function prompt2() {
    for (var i=1; 1<=10;i++){
        console.log(i);
    }

    for(i=1;i<=10;i++){
        console.log("Playing song number "+i);
        if (i==5){
            console.log("Please stop the music");
            break;
        }
    }
}

function prompt3() {
    for(i=1;i<=10;i++){
        console.log("Playing song number "+i);
        if (i==5){
            console.log("Please stop the music");
            break;
        }
    }
}

function prompt4() {
    while(i==i){console.log("ok")}
}

function string() {
    let s1="Coding using JavaScript";
    let s2="Is Fun*";

    console.log(s1.toUpperCase());
    console.log(s2.toLowerCase());
    console.log(s1.length());

    console.log(s1.slice(13,23));
    console.log(S1.chaAt(5));
    console.log(s1.indexOf('J'));
    console.log(s1.concat(s2));
}
    
function array() {
    let names=["Piu","Rosh","Mala","Brinda","David", true, 45];

    console.log(names.slice(2, 3));
}