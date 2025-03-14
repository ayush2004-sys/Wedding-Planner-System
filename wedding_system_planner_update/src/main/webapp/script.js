function redirectToPage() {
    let select = document.getElementById("selectoption");
    let selectedValue = select.value;

    if (selectedValue) {
        // Redirect to correct page, assuming project name is "wedding_system_planner_update"
        window.location.href = "/" + window.location.pathname.split("/")[1] + "/" + selectedValue;
    } else {
        alert("Please select a religion before proceeding.");
    }
}

 function clearForm() {
      document.getElementById("weddingForm").reset();
    }