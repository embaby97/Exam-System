/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkform(form){
                 if(form.user.value === "" ){
                   alert("this is null name");
                   return false;
               }
                 else if(form.pwd.value === ""){
                   alert("this is null password");
                   return false;
               }   
            }
 $(document).ready(function(){
  //global vars
  var userName = $("#user"); //user name field
  var userPass = $("#pwd"); //password field
  

  //function to check name and comment field 
  function checkCommentsForm(){
    if(userName.val() && userPass.val())
      return true;
    else
      return false;
  }

  //When form submitted
  $("#formL").submit(function(){
    if( checkCommentsForm()){
      $.ajax({
        type: "post"
       , url: "LoginController"
       ,data: "user="+userName.val()+"&pwd="+userPass.val(),
       success: function(msg) {$('#targetDiv').hide();$("#targetDiv").html ("<h3>" + msg + "</h3>").fadeIn("slow");}
        });
        }
    else alert("Please fill UserName & Password!");
    return false;
  });
});

