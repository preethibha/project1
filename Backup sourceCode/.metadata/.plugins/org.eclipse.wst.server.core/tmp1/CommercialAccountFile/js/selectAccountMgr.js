
/***********************************************************
********** Mapper Functions for Grids
***********************************************************/
var accountsGridMapper = function(objects){
	var output = '';

	dojo.forEach(objects, function(obj, i){
		
		output += '<div class="grid-data">';
		output += '<div class="responsive-table"><table><tbody><tr>';
		
		//this has to be custome to the type of data the grid is displaying
		output += '<td data-title="Name" class="_40"><a href="#">' + obj.name + '</a></td>';
		output += '<td data-title="Address" class="_60">' + obj.address + '</td>';

		output += '</tr></tbody></table></div>';
		output += '</div>';
	});
	
	dojo.byId("select-account-grid-items").innerHTML = output;
};
var storedAccounts = [
  {
	"name":"Account Name 1",
	"address": "10 Main Street, Sommerville, NJ 08807",
    "id":"1"
  },
  {
	"name":"Account Name 2",
	"address": "192 Old Turnpike Rd, Port Murray, NJ 07865 ",
    "id":"2"
  },
  {
	"name":"Account Name 3",
	"address": "33 Lexington Ave, New York, NY 10001",
    "id":"3"
  }
];

(function(){
	try {
		console.log('Start Select an Account work');
		//get json from session storage
		//var storedAccounts = CbStorageManager.getSessionStoredData('accounts');
		
		new CBgrid (storedAccounts, accountsGridMapper, "select-account-grid");

		
	} catch (e){
		console.log(e);
	}
})();




