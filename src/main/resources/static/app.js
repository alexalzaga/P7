// GET REQUEST - USER BY ID
async function getjugadorById(jugadorId){

    let api = "/api/v1/jugadores/" + jugadorId;

    let res = await fetch(api,{
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
    }});

    console.log("res de getuserbyid:");
    console.log(res);

    let data = null;
    if (res.status == 200){
        data = await res.json();
        console.log(data);
    }else{
        alert("¡Vaya! No se ha podido resolver tu petición");
    }
    return data;
}

// PUT REQUEST -> CAMBIAR EL PERSONAJE DE UN JUGADOR
async function updateJugador(){

    userId = document.getElementById("userIdChange").value;
    userId = userId.toString();

    pNuevo = document.getElementById("perIdChange").value;
    pNuevo = pNuevo.toString();

    let userInfo = await getJugadorById(userId);

    console.log("userInfo content");
    console.log(userInfo);

    if (userInfo != null){
        //let user = userInfo[0];
        //console.log(user);
        let username = userInfo["userame"];
        let password = userInfo["password"];
        let idPersonaje = userInfo["idPersonaje"];

        const dataObj = {
                    "id" : id,
                    "username" : username,
                    "password" : password,
                    "idPersonaje" : idPersonaje
                };

            let res = await fetch("/api/v1/usuarios/005",{
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(dataObj)
            });

            console.log(res);
            showJugadores();
    }else{
        alert("¡Vaya! No se ha podido resolver tu petición");
    }

    /*const dataObj = {
        "id" : userId,
        "userName" : "Pepe",
        "userPwd" : "password5",
        "idPsic" : 20001
    };*/


}

// DELETE REQUEST
async function deletePersonaje(){

    perBorrar = document.getElementById("perBorrar").value;
    perBorrar = perBorrar.toString();
    console.log(perBorrar);
    let api = "/api/v1/personajes/" + perBorrar;

    let res = await fetch(api,{
        method: 'DELETE',
    });
    console.log(res);

    if (res.status == 204){
        console.log(res);
        showPersonajes();
    }else{
        alert("¡Vaya! No se ha podido resolver tu petición");
    }


}

// GET REQUEST - USUARIOS
async function showJugadores(){

        let res = await fetch("/api/v1/jugadores",{
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
        }});

        if (res.status == 200){
            const data = await res.json();
            //console.log(data); //ok
            //let user1 = data[0]; //ok
            div = document.getElementById("mostrar");
            let content = "";
            for (let i = 0; i<data.length; i++){
                let user = data[i];
                let id = user["id"];
                let userName = user["username"];
                let userPwd = user["password"];
                let idPsic = user["idPersonaje"];
                content = content + '<div class="card"><div class="card-body"><h4 class="card-title">' + username + ', ' + id + '</h4><p class="card-text">Psicólogo: ' + idPersonaje + '</p></div></div><br>';
            }
            div.innerHTML = content;
        }else{
            alert("¡Vaya! No se ha podido resolver tu petición");
        }
}

// GET REQUEST - PSICOLOGOS
async function showPersonajes(){

        let res = await fetch("/api/v1/personajes",{
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
        }});

        //console.log(res); //ok

        if (res.status == 200){
            const data = await res.json();
            //console.log(data); //ok
            //let user1 = data[0]; //ok
            divShowPsic = document.getElementById("mostrarPersonajes");
            let content = "";
            for (let i = 0; i<data.length; i++){
                let user = data[i];
                let id = user["id"];
                let psicName = user["name"];
                let psicPwd = user["raza"];
                let employerId = user["oficio"];
                content = content + '<div class="card"><div class="card-body"><h4 class="card-title">' + name + ', ' + id + '</h4><p class="card-text">Employer: ' + oficio + '</p></div></div><br>';
            }

            divShowPsic.innerHTML = content;
        }else{
            alert("¡Vaya! No se ha podido resolver tu petición");
        }
}