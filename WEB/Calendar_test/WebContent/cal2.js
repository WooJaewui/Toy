	
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth();
	var pageYear = $('#year').html();
	var pageMonth = $('#month').html()
	if(pageYear == undefined){
		pageYear = year;
		pageMonth = month+1;
	}
	
	function setDate(pageYear, pageMonth){
		var firstDay = new Date(pageYear, pageMonth-1, 1).getDay();
		var lastDate = new Date(pageYear, pageMonth, 0).getDate();
		var firstDate = 1;
		var index = 0;
		$(".day").each(function(){
			
			if(index < firstDay){
				$(this).text(" ");
			} else if(index == firstDay){
				$(this).text(firstDate);
				firstDate++;
				firstDay++;
			} else if(index > first){
				$(this).text(firstDate);
				firstDate++;
			}
			if(firstDate > lastDate+1){
				
				$(this).text(" ");
			} 
			index ++;
		})
	}
	$('document').ready(function(){
		
		setDate(pageYear, pageMonth);
	
		$('#month').html(pageMonth+"월");
		$('#year').html(pageYear+"년 ");
		$('input[value="◀이전 달"]').click(function(){
			pageMonth -= 1;
			if(pageMonth == 0){
				pageYear -= 1;
				pageMonth = 12;
			}
			$('#month').html(pageMonth+"월");
			$('#year').html(pageYear+"년 ");

			setDate(pageYear, pageMonth);
			
			event.preventDefault();
		})
		$('input[value="다음 달▶"]').click(function(){
			pageMonth += 1;
			if(pageMonth == 13){
				pageYear += 1;
				pageMonth = 1;
			}
			$('#month').html(pageMonth+"월");
			$('#year').html(pageYear+"년 ");
			
			setDate(pageYear, pageMonth);
			
			event.preventDefault();
		})
		
	})