var data = [80, 100, 56, 120, 180, 30, 40, 120, 160];
var maxValue = data.length;

var svgWidth = 500, svgHeight = 300, barPadding = 3;
var barWidth = (svgWidth / data.length);

var svg = d3.select('svg')
			.attr("width", svgWidth + 40)
			.attr("height", svgHeight + 40);
			
var xScale = d3.scaleLinear()
			.domain([0, maxValue])
			.range([0, svgWidth]);
			
var yScale = d3.scaleLinear()
			.domain([0, d3.max(data)])
			.range([svgHeight, 0]);
			
var x_axis = d3.axisBottom()
			.scale(xScale);
			
var y_axis = d3.axisLeft()
			.scale(yScale);
			
var barChart = svg.selectAll("rect")
	.data(data)
	.enter()
	.append("rect")
	.attr("y", function(d) {
		return svgHeight - d*svgHeight/d3.max(data) + 10;
	})
	.attr("actualHeight", function(d) {
		return d;
	})
	.attr("height", function(d) {
		return (d*svgHeight/d3.max(data));
	})
	.attr("width", barWidth - barPadding)
	.attr("transform", function (d, i) {
		var translate = [barWidth * i + 30 + barPadding, 0];
		return "translate("+ translate +")";
	})
	.attr("title", function(d) {
		return d;
	});

svg.append("g")
	.attr("transform", "translate(30, 10)")
	.call(y_axis);
	
var xAxisTranslate = svgHeight + 10;

svg.append("g")
    .attr("transform", "translate(30, " + xAxisTranslate  +")")
    .call(x_axis);
	
$('rect').click(function (){
	console.log('Now we are on the master\'s branch!');
})
	