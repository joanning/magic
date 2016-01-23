Ext.define('com.pacegeeks.model.Card', {
	extend: 'Ext.data.Model',
	fields : [
	          {name: 'id', type: 'int'},
	          {name: 'cardName', type: 'string'},
	          {name: 'cardManaCost', type: 'string'},
	          {name: 'cardConvertedManaCost', type: 'string'},
	          {name: 'cardText', type: 'string'},
	          {name: 'cardPower', type: 'string'},
	          {name: 'cardToughness', type: 'string'},
	          {name: 'rarityId', type: 'string'},
	          {name: 'setId', type: 'string'},
	          {name: 'cardNumber', type: 'string'},
	          {name: 'artistId', type: 'string'},
	          //{name: 'cardColors', type: 'string'},
	          
	          {name: 'cardColors', convert: function(value, record){//finds the actual values we want to report and then concatenates them
	        	  var cardColors = '';
	        	  for (i=0; i < value.length; i++) {
	        		  cardColors = cardColors + value[i].colorDesc;
	        		  if (i+1 < value.length) {
	        			  cardColors = cardColors + " | ";
	        		  }
	        	  }
	      		return cardColors;
	          }},
	          
	          //{name: 'cardTypes', type: 'string'},
	          
	          {name: 'cardTypes', convert: function(value, record){//finds the actual values we want to report and then concatenates them
	        	  var cardTypes = '';
	        	  for (i=0; i < value.length; i++) {
	        		  cardTypes = cardTypes + value[i].typeDesc;
	        		  if (i+1 < value.length) {
	        			  cardTypes = cardTypes + " | ";
	        		  }
	        	  }
	      		return cardTypes;
	          }},
	          
	          //{name: 'cardSubTypes', type: 'string'}
	          
	          {name: 'cardSubTypes', convert: function(value, record){//finds the actual values we want to report and then concatenates them
	        	  var cardSubTypes = '';
	        	  for (i=0; i < value.length; i++) {
	        		  cardSubTypes = cardSubTypes + value[i].subTypeDesc;
	        		  if (i+1 < value.length) {
	        			  cardSubTypes = cardSubTypes + " | ";
	        		  }
	        	  }
	      		return cardSubTypes;
	          }}
	          
	          ], 
	proxy : {
		type : 'rest',
		reader : {
			root : 'rows',
			totalProperty : 'totalCount'
		},
		url : '/magic/cards/paged'
	}
});