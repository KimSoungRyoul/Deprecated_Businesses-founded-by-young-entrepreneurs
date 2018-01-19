$(function(){ 
	
	//mainVisual scroll icon move
	icon_Moving();

	function icon_Moving() {
		$("#mvIcon")
		.animate({ bottom: "40px" }, 700, "", function () {
			$(this)
			.animate({ bottom: "20px" }, 700, "", function () { 
			//자기 호출
			icon_Moving(); });
		});
	}


	var visual =	$('.visual').bxSlider({
		touchEnabled: true,
		auto: true, 
		controls: true,
		mode: 'fade',
		speed:1000
	});
	var bn =	$('.dtList').bxSlider({
		touchEnabled: true,
		auto: true, 
		controls: false,
		mode: 'fade',
		speed:1000
	});
	var bn2 =	$('.psnList').bxSlider({
		touchEnabled: true,
		auto: true, 
		controls: false,
		//mode: 'fade',
		speed:1000
	});

	$('#gnb > li').each(function(){
		var a = $(this);			
		var index = $('#gnb > li').index(this);

		a.hover(function(){
			$('#gnb > li:eq('+ index +')').addClass('on');

		},function(){
			$('#gnb > li:eq('+ index +')').removeClass('on');
		});
	});

	
	//탭(ul) onoff(auto)
	$('.dtBox > div > article:first-child').addClass('on');
	function tabonoff(o) {
		var index = $('.dtBox > div > article').index(o);
		$(o).siblings().removeClass();
		$(o).addClass('on');
	}
	(function(a){
		a.fn.tabonoff_auto=function(p){
			var s_t_i=p&&p.scroller_time_interval?p.scroller_time_interval:"2000"; //롤링타임 수정가능
			var dom=a(this); 
			var s_length=dom.length; 
			var timer; 
			var current = 0; begin(); play();
			function begin(){
				//dom.hover(function(){current = dom.index($(this)); play(); stop()});
				//dom.parent().parent().hover(function(){stop();},function(){timer = setTimeout(play,s_t_i);});
				dom.hover(function(){current = dom.index($(this)); play(); stop()},function(){timer = setTimeout(play,s_t_i);});
			}
			function stop(){clearTimeout(timer);}
			function play(){
				clearTimeout(timer); tabonoff(dom[current]);
				if(current >= s_length-1){current = 0;} else{current ++;}
				timer = setTimeout(play,s_t_i);
			}
		}
	})(jQuery);
	$(".dtBox > div > article").tabonoff_auto();


});
