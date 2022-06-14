const productsControl = new ProductsController();

//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for form to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newItemNameInput = document.querySelector('#newItemNameInput');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemOwner = document.querySelector('#newItemOwner');
    const newItemStartDate = document.querySelector('#newItemStartDate');
    const newItemTargetDate = document.querySelector('#newItemTargetDate');

    /*
        For this assessment, we do not need to do validation
    */

    // Get the values of the inputs - variable names to be same as MySQL columns
    const task = newItemNameInput.value;
    const description = newItemDescription.value;
    const owner = newItemOwner.value;
    const startDate = newItemStartDate.value;
    const targetDate = newItemTargetDate.value;

    // Clear the form after submit
    newItemNameInput.value = '';
    newItemDescription.value = '';
    newItemOwner.value = '';
    newItemStartDate.value = '';
    newItemTargetDate.value = '';

    // Add the new task to the task manager
    productsControl.addItem(task, description, owner, startDate, targetDate);

});
