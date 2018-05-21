$(document).ready(function() {
	feather.replace();
	loadMainBody(infoBoard);
	initSearchInput($("#hashtag-search"));
});

/* Initializations */
function initSearchInput($searchInput){
	$searchInput.keypress(function( event ) {
		  if ( event.which == 13 ) {
			     event.preventDefault();
			     
			     var hashtag = $searchInput.val();
			     
			     if (hashtag[0] == "#"){
			    	 hashtag = hashtag.substring(1);
			     }

			     $.get( "tweets", {hashtag: hashtag}).done(function(data){
	    			 loadMainBody(loadDashBoard);
	    			 loadTableData(data);
	    			 loadTimeChart(timeChartAdapter(data));
	    			 loadCloudTagChart(cloudTagChartAdapter(data));
	    		 })
			     .fail(function() {
			    	 loadMainBody(infoBoard);
			     });
		  }
	});
}

/* Loaders */
function loadMainBody(loader){
	var main = $("#main");
	main.empty();
	main.html(loader());
}

function loadDashBoard(){
	return '<h2 class="mt-4">Tweets</h2>\
	<hr/>\
	<div class="container">\
		<table id="table"></table>\
	</div>\
	<h2 class="mt-4">Graphs</h2>\
	<hr />\
	<div class="container">\
		<div class="row">\
			<div class="col">\
				<h4>Tweets a lo largo del tiempo</h4>\
				<svg id="timeChart" width="500" height="500"></svg>\
			</div>\
			<div class="col">\
				<h4>Palabras Según Uso</h4>\
				<svg id="tagCloud" width="500" height="500"></svg>\
			</div>\
		</div>\
	</div>'
}

function infoBoard(){
	return '<div>\
    <div class="box">\
	        <div class="box-content">\
	            <h1 class="tag-title">Information</h1>\
	            <hr />\
	            <p>Para obtener información de un tag, introduzca en la parte superior derecha el nombre de este sin # y presione Enter.</p>\
	            <br />\
	            <a href="https://github.com/crisgrego/twitter-tracker" class="btn btn-block btn-primary">Mas información.</a>\
	        </div>\
	    </div>\
	</div>'
}

function loadTableData(data){
	$('#table').bootstrapTable({
		height: 400,
		smartDisplay: true,
		columns : [ {
			field : 'profileImageUrl',
			title : 'Profile Image',
			formatter: profileImageFormatter
		}, {
			field : 'fromUser',
			title : 'Name',
			formatter: nameFormatter
		}, {
			field : 'text',
			title : 'Texto'
		}, {
			field : 'favoriteCount',
			title : 'Favorite Count'
		}, {
			field : 'retweetCount',
			title : 'RetweetCount'
		} ],
	data: data 
	});
}

function loadTimeChart(data){
	var svg = d3.select("#timeChart");
	var margin = {top: 20, right: 20, bottom: 30, left: 50};
	var width = +svg.attr("width") - margin.left - margin.right;
	var height = +svg.attr("height") - margin.top - margin.bottom;
	var g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

	var x = d3.scaleTime()
	    .rangeRound([0, width]);

	var y = d3.scaleLinear()
	    .rangeRound([height, 0]);

	var line = d3.line()
	    .x(function(d) { return x(d.date); })
	    .y(function(d) { return y(d.nTweets); });
	
	  x.domain(d3.extent(data, function(d) { return d.date; }));
	  y.domain(d3.extent(data, function(d) { return d.nTweets; }));

	  g.append("g")
	      .attr("transform", "translate(0," + height + ")")
	      .call(d3.axisBottom(x))
	    .select(".domain")
	      .remove();

	  g.append("g")
	      .call(d3.axisLeft(y))
	    .append("text")
	      .attr("fill", "#000")
	      .attr("transform", "rotate(-90)")
	      .attr("y", 6)
	      .attr("dy", "0.71em")
	      .attr("text-anchor", "end")
	      .text("Nº Tweets");

	  g.append("path")
	      .datum(data)
	      .attr("fill", "none")
	      .attr("stroke", "steelblue")
	      .attr("stroke-linejoin", "round")
	      .attr("stroke-linecap", "round")
	      .attr("stroke-width", 1.5)
	      .attr("d", line);
}

function loadCloudTagChart(words){
    var layout = d3.layout.cloud().size([800, 300])
    .size([500, 500])
    .words(words || [])
    .padding(5)
    .rotate(function() { return ~~(Math.random() * 2) * 90; })
    .font("Impact")
    .fontSize(function(d) { return d.size; })
    .on("end", draw);
    
    layout.start();
	
	function draw(words) {
	  d3.select("#tagCloud")
	      .attr("width", layout.size()[0])
	      .attr("height", layout.size()[1])
	    .append("g")
	      .attr("transform", "translate(" + layout.size()[0] / 2 + "," + layout.size()[1] / 2 + ")")
	    .selectAll("text")
	      .data(words)
	    .enter()
	    .append("text")
	      .style("font-size", function(d) { return d.size + "px"; })
	      .style("font-family", "Impact")
	      .attr("text-anchor", "middle")
	      .attr("transform", function(d) {
	        return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
	      })
	      .text(function(d) { return d.text; });
	}
}

/* Formatters */
function profileImageFormatter(value, row, index, field) {
    return '<img src="' + value + '" class="img-fluid" style="border-radius: 50%" alt="Profile Image">';
}

function nameFormatter(value, row, index, field){
	return '<a href="https://twitter.com/'+ value +'">@'+ value +'</a>';
}

/* Adapters */
function timeChartAdapter(data){
	var result = [];
	var tweetsCounter = {};
	
	for (var i = 0; i < data.length; i++) {
		var id = dateToID(new Date(data[i].createdAt));
		tweetsCounter[id] = (tweetsCounter[id] || 0) + 1;
	}
	
	for (var id in tweetsCounter) {
	    if (tweetsCounter.hasOwnProperty(id)) {
	    	result.push({date: idToDate(id), nTweets: tweetsCounter[id]});
	    }
	}
	
	return result;
}

function cloudTagChartAdapter(data){
	if(!data)return [];
	var result = [];
	var wordCounters = {};
	var totalWords = 0;
	
	for (var i = 0; i < data.length; i++) {
	    var words = data[i].text.match(/\b\w+(?=\b)/g);
	    for (var j = 0; j < words.length; j++){
	    	wordCounters[words[j]] = (wordCounters[words[j]] || 0) + 1;
	    }
	    totalWords += words.length;
	}
	
	for (var word in wordCounters) {
	    if (wordCounters.hasOwnProperty(word)) {
	    	result.push({"text":word ,"size":20 + (wordCounters[word]/totalWords) * 90});
	    }
	}
	
	return result;
}

/* Utility Methods */
function dateToID(date){
	// The ISO 8601 syntax (YYYY-MM-DD) is also the preferred JavaScript date format and can be parsed by Date()
	return date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate()+"T"+date.getHours();
}

function idToDate(id){
	var time = id.split("T");
	var date = new Date(time[0]);
	date.setHours(parseInt(time[1]));
	return date;
}