<%
    String domain = request.getRequestURL().toString().replaceAll(request.getRequestURI(),"/");
    String domain2 = domain.replaceAll("http://","http/");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="swlab.css" rel="stylesheet" type="text/css"/>
        <title>Entity Relatedness Test Data</title>
    </head>
    <body>
        <div style="margin:auto; text-align:justify; width:70%; height:90%">
            <h1 style="text-align:center">Entity Relatedness Test Data</h1>            
            <p>
                &emsp;&emsp;The entity relatedness problem refers to the question of computing
                the relationship paths that better describe the connectivity between a given entity
                pair. This dataset supports the evaluation of approaches that address the entity
                relatedness problem. It covers two familiar domains, music and movies, and uses data
                available in IMDb and Last.fm, which are popular reference datasets in these domains.
                The dataset contains 20 entity pairs from each of these domains and, for each entity
                pair, a ranked list with 50 relationship paths. It also contains entity ratings and
                property relevance scores for the entities and properties used in the paths.
            </p>
            <div style="text-align:right">
				<a href="http://swlab.ic.uff.br/fuseki/dataset.html?tab=query&ds=/EntityRelatednessTestData">sparql</a>, 
				<a href="http://linkeddata.uriburner.com/about/html/<%=domain2%>void.ttl%01EntityRelatednessTestData">void</a>,
				<a href="https://doi.org/10.6084/m9.figshare.5143945">doi</a>
            </div>
            <br/>
            <iframe src="https://widgets.figshare.com/articles/5143945/embed?show_title=1" width="100%" height="351" frameborder="0">
            </iframe>
        </div>

        <div prefix="foaf: http://xmlns.com/foaf/0.1/02
             schema: http://schema.org/03
             dcterms: http://purl.org/dc/terms/
             rdf: http://www.w3.org/1999/02/22-rdf-syntax-ns#
             rdfs: http://www.w3.org/2000/01/rdf-schema#
             void: http://rdfs.org/ns/void#
             myvoid: <%=domain%>void.ttl#">
            <div  about="<%=domain%>void.ttl#EntityRelatednessTestData" typeof="http://rdfs.org/ns/void#Dataset">
                <div property="http://www.w3.org/1999/02/22-rdf-syntax-ns#label" content="Entity Relatedness Test Data">
                </div>
            </div>
            <div  about="#this" typeof="http://xmlns.com/foaf/0.1/Document">
                <div rel="http://xmlns.com/foaf/0.1/topic" resource="<%=domain%>void.ttl#EntityRelatednessTestData>">
                </div>
            </div>
        </div>

    </body>
</html>