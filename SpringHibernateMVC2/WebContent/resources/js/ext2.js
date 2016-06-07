/* $('iframe').load(function(){
	alert('به ازای هر تگ  iframe که لود بشه این پیام میاد.');
});
 */

/* <input type = "button" class= "duplicate" value = "God"/>
 $(document).ready(function(){
	 $('.duplicate').click(function(){
		 $(this).after('<input  type="button" value = "God"/>');
	 });
 }); */
 
/*  <input type="button" class="duplicate" value="God"/>
$(document).ready(function(){
	$('.duplicate').live({
		click:function(){
			$(this).after('<input type="button" class="duplicate" value="God"/>');
		}
	});
});
// این کد چون به صورت live داره هندل میکنه event ها رو پس میتونه دکمه هایی تولید کنه و بعد تولید به اونها هم سرویس بده */

/* <input type="file" class="file" />
$(document).ready(function(){
	$('.file').live({
		change: function(){
			$(this).after('<input type="file" class="file" />');
		}
	});
}); */