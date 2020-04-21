<?xml version="1.0" encoding="UTF-8"?>
<!-- XSLT(Extensible Stylesheet Language Template) : XML 텍스트 데이타를
변환하기 위한 XML 기반의 언어로 작성된 파서(Parser) -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- output : XML 텍스트 데이타의 변환 결과를 설정하는 엘리먼트 -->
	<xsl:output method="html" encoding="UTF-8"/>
	<!-- template : XML 텍스트 데이타를 변경하기 위한 정보를 설정하는 상위 엘리먼트 -->
	<!-- match 속성 : XML 텍스트 데이타의 루트 엘리먼트명을 속성값으로 설정 -->
	<xsl:template match="books">
		<ol>
		<!-- for-each : XML 덱스트 데이타의 반복처리를 제공하는 엘리먼트 -->
		<!-- select 속성 : 반복 처리될 엘리먼트명을 속성값으로 설정 -->
		<xsl:for-each select="book">
			<!-- value-of : 값을 제공하는 엘리먼트 -->
			<!-- select 속성 : 값을 제공받을 엘리먼트명을 속성값으로 설정 -->
			<li><b><xsl:value-of select="title"/></b>[<xsl:value-of select="author"/>]</li>
		</xsl:for-each>
		</ol>
	</xsl:template>
</xsl:stylesheet>