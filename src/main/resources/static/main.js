export async function getSeats() {
    let response = await fetch('http://localhost:8080/seats');
    let data = await response.json();
    console.log(data);
    return data;
}

export function showSeats(seats) {
    for (var i = 0; i < seats.length; i++) {
        const newDiv = document.createElement("div");
        newDiv.id = i;
        newDiv.style.height = "40px";
        newDiv.style.margin = "10px";
        const rowNr = document.createElement("h2");
        rowNr.innerHTML = (8-i).toString();
        rowNr.style.display = "inline-block";
        // rowNr.style.margin = "0px";
        rowNr.style.padding = "4px";
        newDiv.appendChild(rowNr);
        const parent = document.querySelector("body");
        parent.appendChild(newDiv);
        let seatNr = 0;
        for (var j = 0; j < seats[i].length; j++) {
            seatNr++;
            const newChild = document.createElement("span");
            newChild.innerHTML = seatNr.toString();
            newChild.style.color = "white";
            newChild.onclick = function(event) {
                if (event.target.style.backgroundColor === "yellow") {
                    event.target.style.backgroundColor = "green";
                    event.target.style.color = "white";
                } else if(event.target.style.backgroundColor === "green") {
                    event.target.style.backgroundColor = "yellow";
                    event.target.style.color = "black";
                }
            }
            if(seats[i][j] === 1) {
                newChild.style.backgroundColor = "red";
                newChild.classList.add("taken");
            } else if(seats[i][j] === 0) {
                newChild.style.backgroundColor = "green";
                newChild.classList.add("seat");
            } else {
                newChild.style.backgroundColor = "yellow"; // Suggested ideal seat
                newChild.style.color = "black";
            }
            newChild.style.margin = "5px";
            newChild.style.padding = "10px";
            if(seatNr > 9) {
                newChild.style.paddingLeft = "5px";
                newChild.style.paddingRight = "5px";
            }
            newChild.style.width = "10px";
            // newDiv.style.width = "10px";
            const parent = document.getElementById(i);
            parent.appendChild(newChild);
        }
        const rowNr2 = document.createElement("h2");
        rowNr2.innerHTML = (8-i).toString();
        rowNr2.style.display = "inline-block";
        // rowNr.style.margin = "0px";
        rowNr2.style.padding = "4px";
        newDiv.appendChild(rowNr2);
    }
}

getSeats().then((data) => showSeats(data));