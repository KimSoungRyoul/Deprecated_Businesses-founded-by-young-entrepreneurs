(function(){ 
	$cnt1 = $(".bn1 > li").length;
	$cnt2 = $(".bn2 > li").length;
	$cnt3 = $(".bn3 > li").length;
	$cnt4 = $(".bn4 > li").length;
	if($cnt1 == 1) {
		var bn =	$('.bn1').bxSlider({
			touchEnabled: false,
			auto: false, 
			controls: true,
			speed:1000
		});
	} else {
		var bn =	$('.bn1').bxSlider({
			touchEnabled: true,
			auto: false, 
			controls: true,
			speed:1000
		});
	}
	if($cnt2 == 1) {
		var bn =	$('.bn2').bxSlider({
			touchEnabled: false,
			auto: false, 
			controls: true,
			speed:1000
		});
	} else {
		var bn =	$('.bn2').bxSlider({
			touchEnabled: true,
			auto: false, 
			controls: true,
			speed:1000
		});
	}
	if($cnt3 == 1) {
		var bn =	$('.bn3').bxSlider({
			touchEnabled: false,
			auto: false, 
			controls: true,
			speed:1000
		});
	} else {
		var bn =	$('.bn3').bxSlider({
			touchEnabled: true,
			auto: false, 
			controls: true,
			speed:1000
		});
	}
	if($cnt4 == 1) {
		var bn =	$('.bn4').bxSlider({
			touchEnabled: false,
			auto: false, 
			controls: true,
			speed:1000
		});
	} else {
		var bn =	$('.bn4').bxSlider({
			touchEnabled: true,
			auto: false, 
			controls: true,
			speed:1000
		});
	}


	//팝업 열기///////////////////////////////////////
	$('.popup, .fade').hide();
	
	$('.imev').click( function(){
		var id = $(this).attr('data-id');
		$('.fade, #pofol'+id).show();
		$('body, html').css({
			'overflow-y' : 'hidden'
		});
		//popup page rolling
		var imgBn = $('#pofol'+id+' .rolling').bxSlider({
			auto: false, 
			controls: true,
			speed:200
		});
	});
	//팝업닫기
	$('.fade').click( function(){
		$('.popup, .fade').hide();
		$('body, html').css({
				'overflow-y' : 'auto'
		});
	});


/*	
	//팝업 열기
	$('.popup, .fade').hide();
	$('.bn').click( function(){
		$('.popup, .fade').show();
		$('body, html').css({
			'overflow-y' : 'hidden'
		});
	});
	//팝업닫기
	$('.fade').click( function(){
		$('.popup, .fade').hide();
		$('body, html').css({
				'overflow-y' : 'auto'
		});
	});
	
	*/
	

});

