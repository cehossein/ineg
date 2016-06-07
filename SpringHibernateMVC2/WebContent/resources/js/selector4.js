/* 	<p>Name</p>
	<input type="text"/>
	<p>Email</p>
	<input type= "text"/><br /><br />
	<input type = "button" value="Sign up">
$(':text').focusin(function(){
	$(this).css('backgroundColor','yellow');
});
$(':text').blur(function(){
	$(this).css('backgroundColor','white');
});
$(':button').click(function(){
	$(this).attr('value','Wait...');
	$(this).attr('disabled',true);
});
 */
 
/*  	<p>Font Size : <a id="plus" href="#"> + </a>	<a id="mine" href="#"> - </a>	<br /> </p>
	<p> God </p>
 function change_size(element , size){
	 var current_size = parseInt(element.css('fontSize'));
	 var new_size;
	 if(size == 'plus'){
		 new_size = current_size + 2;
	 }
	 else{
		 new_size = current_size - 2;
	 }
	 element.css('fontSize', new_size + 'px');
 }
 
 $('#plus').click(function(){
	change_size($('p'),'plus');
 }); 
 $('#mine').click(function(){
	change_size($('p'),'mine');
 });
  */