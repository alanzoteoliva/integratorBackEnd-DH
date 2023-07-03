// Función para agregar un paciente
window.addEventListener('load', function () {

        // Obtener el formulario y la tabla de pacientes
        const pacienteForm = document.getElementById('paciente-form');
        const pacientesBody = document.getElementById('pacientes-body');

        // Agregar evento al botón de agregar paciente
        const agregarButton = document.getElementById('agregar-button');
        agregarButton.addEventListener('click', agregarPaciente);

            // Obtener los valores del formulario
            const nombre = document.getElementById('nombre-input').value;
            const apellido = document.getElementById('apellido-input').value;
            const domicilio = document.getElementById('domicilio-input').value;
            const dni = document.getElementById('dni-input').value;
            const fechaAlta = document.getElementById('fecha-alta-input').value;

            // Crear una nueva fila en la tabla con los datos del paciente
            const fila = document.createElement('tr');
            const nombreTd = document.createElement('td');
            const apellidoTd = document.createElement('td');
            const domicilioTd = document.createElement('td');
            const dniTd = document.createElement('td');
            const fechaAltaTd = document.createElement('td');

            nombreTd.textContent = nombre;
            apellidoTd.textContent = apellido;
            domicilioTd.textContent = domicilio;
            dniTd.textContent = dni;
            fechaAltaTd.textContent = fechaAlta;

            fila.appendChild(nombreTd);
            fila.appendChild(apellidoTd);
            fila.appendChild(domicilioTd);
            fila.appendChild(dniTd);
            fila.appendChild(fechaAltaTd);

            pacientesBody.appendChild(fila);

            // Limpiar los campos del formulario
            pacienteForm.reset();
}