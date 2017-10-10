function drop(element) {
    
    var textfield = document.getElementById(element.id);
    
    var value = textfield.value;
    var length = value.length;
    var tX = textfield.style.left + (10 * (length + 1));
    var tY = textfield.style.top;
    var lastChar = value.substr(length - 1);
    
    
    var char = document.createElement("char");
    
    char.innerHTML = lastChar;
     char.style.left = getRandom(0, 1920) + "px";
     char.style.color = "aqua"
    char.style.width = 500;
    char.style.height = 500;
    char.style.position = "absolute";
    
    document.body.appendChild(char);
    
    var op = 1.0;
    var pos = 170;
    var id = setInterval(frame, 8);
    var exitPos = 600;
    function frame() {
        if (pos == exitPos) {
            document.body.removeChild(char);
            clearInterval(id);
        } else {
            pos++;
            char.style.top = pos + 'px';
            
            if (pos % 25 == 0) {
                char.style.opacity = op;
                op -= 0.1;
            }
        }
    }
       
       function getRandom(min, max) {
    return Math.floor((Math.random() * max) + min)    
}
}

