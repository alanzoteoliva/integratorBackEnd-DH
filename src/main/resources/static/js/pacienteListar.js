window.addEventListener('load', function () {

  const url = '/pacientes';
  const settings = {
      method: 'GET'
  }

  fetch(url,settings)
       .then(response => response.json())
       .then(data => {
                    console.log(data)
                    for(paciente of data){
                    var tabla = document.getElementById("tablaPacientes");
                    var fila = tabla.insertRow();
                    fila.innerHTML =`${odontologo.dni} - ${odontologo.apellido} - ${odontologo.nombre} - ${odontologo.turnos} `
                    }
        }).catch(error => {
             alert("Error: " + error);
        })
})