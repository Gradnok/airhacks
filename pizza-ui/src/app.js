class PizzaView {

    constructor() {
        console.log('init');
        this.initializeView();
        this.initListeners();
        this.registerWebSockets();
    }    

    initListeners() { 
        this.button = document.querySelector("button");
        this.button.addEventListener('click', e =>
            fetch("http://localhost:8282/pizza/resources/orders").
                then(r => r.json()).then(j => this.div.innerText = j)
        );   
    }    

    initializeView() {
        this.div = document.querySelector('#output');
        this.div.innerText = " hey duke";

    }


    registerWebSockets() { 
        this.notifications = document.querySelector('#notifications');

        this.socket = new WebSocket("ws://localhost:8282/pizza/notifications");
        this.socket.onopen = e => console.log(e);

        this.socket.onmessage = m => console.log(this.notifications.innerText = m.data);


    }    



}

fetch("http://localhost:8282/pizza/resources/orders").
    then(r => r.json()).then(j => console.log(j));


let pizzaView = new PizzaView();



let soptim = "duke";
{ 
    let soptim = "fluke";
}
console.log(soptim);