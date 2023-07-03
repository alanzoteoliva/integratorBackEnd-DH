window.addEventListener('load', function () {

  const url = '/odontologos';
  const settings = {
      method: 'GET'
  }

  fetch(url,settings)
       .then(response => response.json())
       .then(data => {
                    console.log(data)
                    const odontologosBody = document.getElementById('bodyOdontologos');
                    for(odontologo of data){
                    /*var tabla = document.getElementById("tablaOdontologos");
                    var fila = tabla.insertRow();
                    fila.innerHTML =`${odontologo.id} - ${odontologo.nombre} `*/
                                    const fila = document.createElement('tr');
                                    const id = document.createElement('td');
                                    const apellido = document.createElement('td');
                                    const nombre = document.createElement('td');
                                    const matricula = document.createElement('td');

                                    id.textContent = odontologo.id;
                                    apellido.textContent = odontologo.apellido;
                                    nombre.textContent = odontologo.nombre;
                                    matricula.textContent = odontologo.matricula;

                                    fila.appendChild(id);
                                    fila.appendChild(apellido);
                                    fila.appendChild(nombre);
                                    fila.appendChild(matricula);

                                    odontologosBody.appendChild(fila);
                    }

        ).catch(error => {
             alert("Error: " + error);
        })
})