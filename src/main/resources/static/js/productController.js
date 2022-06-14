//On the To-Do List page, display the task name, description, owner name, start date, target end date, and status
const createHTMLList = (index, task, description, owner, startDate, targetDate) =>
`
<div class="col-lg-12">
<div class="card" style="width: 100%;">
    <div class="card-body">
        <h6 class="card-title">Task #${index+1}: ${task}</h6>
        <p class="card-text">Description: ${description}</p>
        <p class="card-text">Owner: ${owner}</p>
        <p class="card-text">Start Date: ${startDate}</p>
        <p class="card-text">Target Date: ${targetDate}</p>
    </div>
</div>
</div>
`;

class ProductsController 
{
    constructor()
    {
        //Configuration of dev URL - For this assessment, we will just use localhost
        this.domainURL_Dev = "http://localhost:8080/";

        this.addItemAPI = this.domainURL_Dev + "item/add";
        this.allItemAPI = this.domainURL_Dev + "item/all";

        this._items = [];       //create an array to store the details of to-do items
    }

    //POST method to add new to-do item into the database
    addItem(task, description, owner, startDate, targetDate)
        {
            var productController = this;
            const formData = new FormData();
            formData.append('task', task);
            formData.append('description', description);
            formData.append('owner', owner);
            formData.append('startDate', startDate);
            formData.append('targetDate', targetDate);

           fetch(this.addItemAPI, {
                 method: 'POST',
                 body: formData
                 })
                 .then(function(response) {
                     console.log(response.status); // Show the submission status
                     if (response.ok) {
                         alert("Successfully added new TODO task!")
                     }
                 })
                 .catch((error) => {
                     console.error('Error:', error);
                     alert("Error adding task to TODO list")
                 });
        }

    //Fetch method to retrieve data from database using the REST API endpoint from Spring Boot
    displayItem()
    {
        let productController = this;
        productController._items = [];

        fetch(this.allItemAPI)
            .then((resp) => resp.json())
            .then(function(data) {
                console.log("2. receive data")
                console.log(data);
                data.forEach(function (item, index) {

                    const itemObj = {
                        id: item.id,
                        task: item.task,
                        description: item.description,
                        owner: item.owner,
                        startDate: item.startDate,
                        targetDate: item.targetDate
                   };
                    productController._items.push(itemObj);
              });

              productController.renderProductPage();

            })
            .catch(function(error) {
                console.log(error);
            });
    }

    //Display fetched items on the To-Do List page
    renderProductPage()
    {
        let productHTMLList = [];

        for (let i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(i, item.task, item.description, item.owner, item.startDate, item.targetDate);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and separate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;
    }

}   //End of ProductsController class
