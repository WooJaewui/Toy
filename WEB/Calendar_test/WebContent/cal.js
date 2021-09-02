var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth();
	var pageYear = $('#year').html();
	var pageMonth = $('#month').html()
	if(pageYear == undefined){
		pageYear = year;
		pageMonth = month+1;
	}
	var firstDay = new Date(pageYear, pageMonth-1, 1).getDay();
	var lastDate = new Date(pageYear, pageMonth, 0).getDate();
	var firstDate = 1;
	var index = 0;
	$('document').ready(function(){
		$(".day").each(function(){
			if(index < firstDay){
				$(this).text(" ");
			} else if(index == firstDay){
				$(this).text(firstDate);
				firstDate++;
				firstDay++;
			} 
			if(firstDate > lastDate+1){
				$(this).text(" ");
			} 
			index ++;
		})

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
			
			firstDay = new Date(pageYear, pageMonth-1, 1).getDay();
			lastDate = new Date(pageYear, pageMonth, 0).getDate();
			firstDate = 1;
			index = 0;
			$(".day").each(function(){
				if(index < firstDay){
					$(this).text(" ");
				} else if(index == firstDay){
					$(this).text(firstDate);
					firstDate++;
					firstDay++;
				} 
				if(firstDate > lastDate+1){
					$(this).text(" ");
				} 
				index ++;
			})
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
			
			firstDay = new Date(pageYear, pageMonth-1, 1).getDay();
			lastDate = new Date(pageYear, pageMonth, 0).getDate();
			firstDate = 1;
			index = 0;
			$(".day").each(function(){
				if(index < firstDay){
					$(this).text(" ");
				} else if(index == firstDay){
					$(this).text(firstDate);
					
				} else if(index > firstDay){
					$(this).text(firstDate);
					firstDate++;
				}
				if(firstDate > lastDate+1){
					$(this).text(" ");
				} 
				index ++;
			})
			event.preventDefault();
		})
		
	})