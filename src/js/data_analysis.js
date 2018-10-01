var dataset = [80, 100, 56, 120, 180, 30, 40, 120, 160, 190, 20];
var maxValue = dataset.length;
var svgWidth = 1000, svgHeight = 500, barPadding = 3, marginTop = 40, marginSide = 40,
	paddingTop = 50, paddingLeft = 30;
var barWidth = (svgWidth / dataset.length);
var svg = d3.select('svg')
			.attr("width", svgWidth + marginSide)
			.attr("height", svgHeight + marginSide + marginTop);

setaxis(dataset, svg);
setBars(svg);
setTips(svg);
hideTips(svg);
setOnClickListenerToBars();
setOnMouseoverListenerToBars();

// This function sets a coordinate axis
function setaxis(dataset, svg) {
	var xScale = d3.scaleLinear()
				.domain([0, maxValue])
				.range([0, svgWidth]);
				
	var yScale = d3.scaleLinear()
				.domain([0, d3.max(dataset)])
				.range([svgHeight, 0]);
				
	var x_axis = d3.axisBottom()
				.scale(xScale);
				
	var y_axis = d3.axisLeft()
				.scale(yScale);
				
	svg.append("g")
		.attr("class", "axis")
		.attr("transform", "translate(" + paddingLeft + ", " + paddingTop + ")")
		.call(y_axis);
		
	var xAxisTranslate = svgHeight + paddingTop;

	svg.append("g")
		.attr("class", "axis")
		.attr("transform", "translate(" + paddingLeft + ", " + xAxisTranslate  +")")
		.call(x_axis);	
}
	
// This function sets bars to the coordinate axis
function setBars(svg) {
	var barChart = svg.selectAll("rect")
		.data(dataset)
		.enter()
		.append("rect")
		.attr("class", "bars")
		.attr("id", function(d, i) {
			return i;
		})
		.attr("y", function(d) {
			return svgHeight - d*svgHeight/d3.max(dataset) + paddingTop;
		})
		.attr("actualHeight", function(d) {
			return d;
		})
		.attr("height", function(d) {
			return (d*svgHeight/d3.max(dataset));
		})
		.attr("width", barWidth - barPadding)
		.attr("transform", function (d, i) {
			var translate = [barWidth * i + paddingLeft + barPadding, 0];
			return "translate("+ translate +")";
		})
		.attr("title", function(d) {
			return d;
		});
}

// This function sets tips for each column
function setTips(svg) {
	
	// 1. create containers for tips
	var tipRectWidth = (barWidth - barPadding) * 0.618;
	var tipRectLeftPadding = (barWidth - tipRectWidth) / 2;
	var barTips = svg.selectAll("text.labels")
		.data(dataset)
		.enter()
		.append("g")
		.attr("class", "tip")
		.attr("id", function(d, i) {
			return "tip-" + i;
		});
		
	// 2. set a rounded rectangle for each tip
		barTips.append("rect")
		.attr("id", function(d, i) {
			return "tiprect-" + i;
		})
		.attr("class", "tip tip-rect")
		.attr("y", function(d) {
			return svgHeight - d*svgHeight/d3.max(dataset) + paddingTop - 44;
		})
		.attr("rx", 10)
		.attr("ry", 10)
		.attr("height", 30)
		.attr("width", tipRectWidth)
		.attr("transform", function (d, i) {
			var translate = [(barWidth * i + paddingLeft + barPadding) + tipRectLeftPadding, 0];
			return "translate("+ translate +")";
		});
		
	// 3. set a triangle for each tip
	var tipTriaWidth = (barWidth - barPadding) * 0.1;
	var tipTriaLeftPadding = (barWidth - tipTriaWidth) / 2;
	barTips.append("polygon")
		.attr("id", function(d, i) {
			return "tiptria-" + i;
		})
		.attr("class", "tip tip-tria")
		.attr("points", function(d, i) {
			
			// set the x and y value of each point of the triangle
			var tipTriaYTop = svgHeight - d*svgHeight/d3.max(dataset) + paddingTop - 14;
			var tipTriaYBottom = svgHeight - d*svgHeight/d3.max(dataset) + paddingTop - 9;
			var p1x = (barWidth * i + paddingLeft + barPadding) + tipTriaLeftPadding;
			var p1y = tipTriaYTop;
			var p2x = (barWidth * i + paddingLeft + barPadding) + tipTriaLeftPadding + tipTriaWidth;
			var p2y = tipTriaYTop;
			var p3x = (p1x + p2x)/2;
			var p3y = tipTriaYBottom;
			return (p1x + "," + p1y
					+ " " +
					p2x + "," + p2y
					+ " " +
					p3x + "," + p3y);
		});
}

// This function hides all tips on the page loaded
function hideTips(svg) {
	svg.selectAll(".tip").attr("visibility", "hidden");
}

// This function sets onClick listener to the bars
function setOnClickListenerToBars() {
	$('.bars').click(function (){
		console.log('I, ' + $(this).attr('actualHeight') + ', felt being clicked!');
	})
}

// This function sets onMouseover/out listener to the bars
function setOnMouseoverListenerToBars() {
	svg.selectAll(".bars")
		.on("mouseover", handleMouseOver)
		.on("mouseout", handleMouseOut);
}

// This function handles mouseover event
function handleMouseOver(d,i) {  // Add interactivity

	// Use D3 to select element, change color and size
	d3.select(this).classed("bars-hovered", true);
	//d3.select(this).style("fill", "gray");
	d3.select("#tip-" + i)
		.selectAll('*')
		.attr("visibility", "visible");
}

// This function handles mouseout event
function handleMouseOut(d,i) {  // Add interactivity

	// Use D3 to select element, change color and size
	d3.select(this).classed("bars-hovered", false);
	//d3.select(this).style("fill", "black");
	d3.select("#tip-" + i)
		.selectAll('*')
		.attr("visibility", "hidden");
}