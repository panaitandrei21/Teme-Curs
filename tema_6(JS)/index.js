class Vehicle {
    constructor(maxSpeed, tank, lps, kmps, money=0) {
        this.currentSpeed = 0;
        this.maxSpeed = maxSpeed;
        this.tank = tank;
        this.lps = lps;
        this.kmps = kmps;
        this.gasConsumed = 0;
        this.kmDrove = 0;
        this.expenses = 0;
        this.money = money;
    }
   
    drive() {
        if (this.tank <= 0) {
            console.log("Out of gas! Please fill up.");
            this.currentSpeed = 0;
            return;
        }
        this.currentSpeed = this.maxSpeed;
        this.tank -= this.lps;
        this.kmDrove += this.kmps;
        this.gasConsumed += this.lps;
    }

    putGas(amount) {
        if (this.money < amount) {
            console.log("Not enough money to fill gas!");
            return;
        }
        this.tank += amount;
        this.money -= amount;
        this.expenses += amount;
    }

    pay(amount) {
        this.money += amount;
    }
    
}
class Motorcycle extends Vehicle {
    constructor(money=0) {
        super(120, 30, 0.3, 1.5, money);
    }
}

class Car extends Vehicle {
    constructor(money=0) {
        super(200, 50, 0.5, 2, money);
    }
}

class Truck extends Vehicle {
    constructor(money=0) {
        super(100, 100, 1, 0.9, money);
    }
}

let Dacia = new Car();
console.log(Dacia);
Dacia.drive();
Dacia.putGas(20);
Dacia.pay(50);

setInterval(() => {
    Dacia.drive();
    console.log(`Driven: ${Dacia.kmDrove} km, Gas Left: ${Dacia.tank} liters`);

    document.querySelector("#car-moving").innerHTML = `Driven: ${Dacia.kmDrove} km, Gas Left: ${Dacia.tank} liters`;
}, 1000);