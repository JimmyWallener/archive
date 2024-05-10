var myTaskArray = []

var date = new Date();

$(function () {

  $("#addBtn").click(function () {
     var newItem = $('#inputUser').val();

     if (myTaskArray.length >= 10) {
             alert("Your Schedule for today is now full!");
            $('#inputUser').val('');
                        return;
              }
     if (newItem.trim() == '' || newItem.length < 4) {
         return;
       } else {

       myTaskArray.push(newItem);
         $("#list").append("<li><input type = 'checkbox' id = 'removeTask' > " + " " + newItem + "</li>");
          // Adds function for setting completed attributes such as green background and line-through.
          
            $("input:checkbox").click(function () {
                 var $this = $(this);
                 if (this.checked) {
                     $this.parent().addClass('completed');
                    
                 } else {
                     $this.parent().removeClass('completed');
                 }
             });
         }
         $('#inputUser').val('');
     });
           
           
           
           
                // Added function to be able to sort element and shift them around. 
                // connectWith acts as an refresher and checks for newly added elements. Needed since <li> elements are added dynamically.
                // tolerance keeps the sortable within the <ul></ul>.

        $('.sortList').sortable({
        connectWith: ".sortList",
        tolerance: "pointer"
         });


                // Added tooltip for h1. Document checks for title and displays it as a tooltip.
         $(function () {
         $('document').tooltip();
         });

                // Once checkbox is clicked, element can be removed by clicking trashcan.
                // Problem left to be solved : 
                // .remove() function only deletes element but does not remove item from array. Need to work out a solution for that.

         $("#removeBtn").click(function () {
             //array for the deleted items in the array
             let itemsToRemove = [];
            $('#list').children().filter(function (index) {
         let removeThis = this.firstChild.checked;
            if (removeThis) {
                 itemsToRemove.push(index); }
                 return removeThis;
                    }).remove();
                    myTaskArray = myTaskArray.filter(function (value, index) {
                        return !itemsToRemove.includes(index);
                    });
                });

                // Color randomiser that takes any value between 0-255 and inserts it into css background color. 
                // Set clickfunction to <h1> and will display in container area.
                $("h1").click(function () {
                    $(".container").each(function () {
                        let colorRed = Math.floor((Math.random() * 256));
                        let colorGreen = Math.floor((Math.random() * 256));
                        let colorBlue = Math.floor((Math.random() * 256));
                        $(this).css("background-color", "rgba(" + colorRed + "," + colorGreen + "," + colorBlue + ")");
                    });
                });

                //stylar input field
                var inputFields = $("input:text"); inputFields.focus(function () {
                    $(this).css("box-shadow", "0 0 5px #181");
                });

            });
