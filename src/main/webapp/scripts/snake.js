var Snake_map = new Map();
var food = new Map();
var direction = 'r';
var score = 0;
var snake_color = "#C3FDB8";
init();

setInterval(loop, 200);


function loop() {
    if(!food.get("exist")) {
        generateFood();
    }

    document.getElementById("mark").innerHTML="当前分数 :" +  score.toString();

    for(let i = Snake_map.size; i > 1; i--) {
        let temp = Snake_map.get(i);
        temp.style.top = Snake_map.get(i-1).style.top;
        temp.style.left = Snake_map.get(i-1).style.left;
        Snake_map.set(i, temp);
    }
    let temp = Snake_map.get(1);

    switch (direction){
        case 'u':temp.style.top = parseInt(temp.style.top.slice(0,-2))-30+"px";break;
        case 'd':temp.style.top = parseInt(temp.style.top.slice(0,-2))+30+"px";break;
        case 'r':temp.style.left = parseInt(temp.style.left.slice(0,-2))+30+"px";break;
        case 'l':temp.style.left = parseInt(temp.style.left.slice(0,-2))-30+"px";break;
    }
    Snake_map.set(1,temp);
    eat_food();

}
function eat_food() {
    let temp = Snake_map.get(1);
    if(food.get("div").style.top === temp.style.top && food.get("div").style.left === temp.style.left){
        score += 10;
        let last = Snake_map.get(Snake_map.size);
        let b = document.getElementById("background");
        let position = b.getBoundingClientRect();
        let left = position.left;
        let top = position.top;

        let x = (parseInt(last.style.left)-Math.floor(left)-5)/30;
        let y = (parseInt(last.style.top)-Math.floor(top)-5)/30;

        console.log(x + ' ' + y);
        Snake_map.set(Snake_map.size+1, createNode(x,y,Snake_map.size+1, snake_color, "square"));
        food.get("div").remove();
        food.clear();
        generateFood();

    }
}

function generateFood() {
    let f = 0;let x;let y;
    let b = document.getElementById("background");
    let position = b.getBoundingClientRect();
    while(1) {
        x = Math.floor(Math.random() * 15);
        y = Math.floor(Math.random() * 15);
        let left=position.left+x*30+5+"px";
        let top =position.top+y*30+5+"px";

        for(let i = 1; i <= Snake_map.size; i++) {
            let temp = Snake_map.get(i);
            if(temp.style.top === left && temp.style.left === top){
                f = 1;
                break;
            }
        }
        if(f===1) continue;
        else break;
    }
    console.log("x:"+x+" "+"y:"+y);

    let color = ["#EDDA74", "#E77471", "#C6DEFF" , "#7FFFD4"];
    let index = Math.floor(Math.random() * 4);


    let temp = createNode(x,y,2333,color[index],"circle");
    food.set("exist", true);
    food.set("div", temp);
}

function init() {
    drawSnake();

}
function drawSnake() {
    init_snake();
}
function init_snake() {
    Snake_map.set(1, createNode(9,9,1, snake_color, "square"));
    Snake_map.set(2, createNode(8,9,2, snake_color, "square"));
    Snake_map.set(3, createNode(7,9,3, snake_color, "square"));
    Snake_map.set(4, createNode(6,9,4, snake_color, "square"));
}
function createNode(x,y,id, color, type) {
    let b = document.getElementById("background");
    let position = b.getBoundingClientRect();
    let left = position.left;
    let top = position.top;
    let div=document.createElement("div");
    div.style.width=(parseInt(b.style.width.slice(0,-2))/20).toString();
    div.style.height=(parseInt(b.style.width.slice(0,-2))/20).toString();
    div.style.backgroundColor=color;
    div.id = "div"+id.toString();
    div.style.position="absolute";
    div.style.left=Math.floor(left)+x*30+5+"px";
    div.style.top=Math.floor(top)+y*30+5+"px";

    console.log(div.style.left + " " + div.style.top);
    if(type === "circle") {
        div.style.border="2px black solid";
        div.style.borderRadius="15px";
    }
    if(type === "square"){
        div.style.border="2px black solid";
    }
    b.appendChild(div);
    return div;
}

document.addEventListener("keydown", function(event) {
    switch (event.keyCode) {
        case 37: if(direction!=='r')direction='l';break;
        case 38: if(direction!=='d')direction='u';break;
        case 39: if(direction!=='l')direction='r';break;
        case 40: if(direction!=='u')direction='d';break;
    }
});