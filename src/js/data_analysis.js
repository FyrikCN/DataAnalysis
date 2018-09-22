var data = [80, 100, 56, 120, 180, 30, 40, 120, 160];

var svgWidth = 500, svgHeight = 300;

var svg = d3.select('svg')
			.attr("width", svgWidth + 40)
			.attr("height", svgHeight + 40);
			
var xScale = d3.scaleLinear()
			.domain([0, d3.max(data)])
			.range([0, svgWidth]);
			
var yScale = d3.scaleLinear()
			.domain([0, d3.max(data)])
			.range([svgHeight, 0]);
			
var x_axis = d3.axisBottom()
			.scale(xScale);
			
var y_axis = d3.axisLeft()
			.scale(yScale);

svg.append("g")
	.attr("transform", "translate(30, 10)")
	.call(y_axis);
	
var xAxisTranslate = svgHeight + 10;

svg.append("g")
    .attr("transform", "translate(30, " + xAxisTranslate  +")")
    .call(x_axis);
	