Ext.define('com.pacegeeks.model.Artist', {
	extend: 'Ext.data.Model',
	fields : [
	          {name: 'artistName',
	        	  convert: function(value, record) {
	        		  var firstName  = record.get('artistFirstName'),
	        		  lastName  = record.get('artistLastName');
	        		  if(lastName!=''){
	        			  name = lastName + ' , ' + firstName;
	        		  }else{
	        				name = firstName;
	        		  }
	        		  return name;
	        		  }
	          },
	          {name: 'id', type: 'string'},
	          {name: 'artistFirstName', type: 'string'},
	          {name: 'artistLastName', type: 'string'}
	          ], 
	proxy : {
		type : 'rest',
		url : '/magic/artists'
	}
});