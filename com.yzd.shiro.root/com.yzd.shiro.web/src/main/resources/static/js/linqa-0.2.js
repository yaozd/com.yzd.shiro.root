/**============================================================= *
*
* linqa.js
*
* version 0.1
*
* autor: ximenwang, mail: oohacker@qq.com
*
* license: LGPL 3.0
* ============================================================== */

String.format = function(format) {
  if(format == null) throw 'format string cannot be null!';
  var str = format;
  for(var i=1; i<arguments.length; i++) {
    var reg = new RegExp("\\{" + (i-1) + "\\}", "gi");
    str = str.replace(reg, arguments[i]);
  }
  
  return str;
};


Array._createStdKey = function(a, i, it, projection) {
  var val = projection(a, i, it);
  if(Array.isArray(val)) return val;
  return [val];
};

Array._stdLinqCompare = function(a,b) {
  for(var i=0; i<a.length; i++) {
    if(a[i] == b[i]) continue;
    else if(a[i] < b[i]) return -1;
    else return 1;
  }
  
  return 0;
};


Array.Lazer = function(assert) {
  var run = assert()==true;
  return {"then": function(callback) {
      if(run) callback();
    }
  };
}



Array.prototype.each = function(callback) {
  for(var i=0; i<this.length; i++) {
    callback(this[i], i, this);
  }
};


Array.prototype.select = function (projection) {
  var arr = [];
  for(var i=0; i<this.length; i++) {
    arr.push(projection(this[i], i, this));
  }
  
  return arr;
};



Array.prototype.where = function (predicate) {
  var arr = [];
  for(var i=0; i<this.length; i++) {
    if(predicate(this[i], i, this)) {
      arr.push(this[i]);
    }
  }
  
  return arr;
};


Array.prototype.first = function(predicate) {
  
  if(typeof(predicate) == 'undefined') return this.length > 0 ? this[0] : null;
  
  for(var i=0; i<this.length; i++) {
    if(predicate(this[i], i, this)) return this[i];
  }
  
  return null;
};

Array.prototype.last = function(predicate) {
  
  if(typeof(predicate) == 'undefined') return this.length > 0 ? this[this.length-1] : null;
  
   for(var i=this.length-1; i>=0; i--) {
    if(predicate(this[i], i, this)) return this[i];
  }
  
  return null;
};


Array.prototype.orderAsc = function(projection) {
  
  if(this.length == 0) return [];
  
  if (typeof(projection) == 'undefined') projection  = (a) => a;
  
  var arr = this.select( (a,i,it) => ({"val": a, "key": Array._createStdKey(a,i,it,projection) }) );

  for(var i=0; i<this.length-1; i++) {
    var minPos = i;
    for(var j=i+1; j<this.length; j++) {
      if(Array._stdLinqCompare(arr[minPos].key, arr[j].key) > 0) {
        minPos = j;
      }
    }
    
    if(minPos != i) {
      var temp = arr[i];
      arr[i] = arr[minPos];
      arr[minPos] = temp;
    }
  }
  
  return arr.select( a => a.val );
};


Array.prototype.orderDesc = function(projection) {
  if(this.length == 0) return [];
  
  if (typeof(projection) == 'undefined') projection  = (a) => a;
  
  var arr = this.select((a,i,it) => ({"val": a, "key": Array._createStdKey(a,i,it,projection) }));
  for(var i=0; i<this.length-1; i++) {
    var minPos = i;
    for(var j=i+1; j<this.length; j++) {
      if(Array._stdLinqCompare(arr[minPos].key, arr[j].key) < 1) {
        minPos = j;
      }
    }
    
    if(minPos != i) {
      var temp = arr[i];
      arr[i] = arr[minPos];
      arr[minPos] = temp;
    }
  }
  
  return arr.select(a=>a.val);
};



Array.prototype.groupBy = function(projection) {
  
  function isSameKey(a,b) {
    for(var i=0; i<a.length; i++) {
      if(a[i] != b[i]) return false;
    }
    
    return true;
  }
  
  var arr = this.select( (a,i,it) => ({"val":a, "key": Array._createStdKey(a,i,it,projection) }));
  var rslt = [];
  for(var i=0; i<arr.length; i++) {
    var g = rslt.first(a => isSameKey(a.key, arr[i].key) );
    if(g == null) {
      g = {"key":arr[i].key, "list":[arr[i].val]};
      rslt.push(g);
    }
    else {
      g.list.push(arr[i].val);
    }
  }
  
  rslt.each(a => {
    if(a.key.length == 1) a.key = a.key[0];
  });
  
  return rslt;
};


Array.prototype.sum = function(projection) {
  if(this.length == 0) return null;
  
  if(typeof(projection) == 'undefined') projection = a => a;
  
  var sumV = 0;
  this.each(a => sumV+=projection(a) );
  return sumV;
};

Array.prototype.avg = function(projection) {
  if(this.length == 0) return null;
  
  if(typeof(projection) == 'undefined') projection = a => a;
  
  return this.sum(projection) / this.length;
};


Array.prototype.min = function(projection) {
  if(this.length == 0) return null;
  
  if(typeof(projection) == 'undefined') projection = a => a;
  
  var arr = this.select( (a,i,it) => ({"val":a, "key": Array._createStdKey(a,i,it,projection) }));
  var minPos = 0;
  for(var i=1; i<arr.length; i++) {
    if(Array._stdLinqCompare(arr[minPos].key, arr[i].key) > 0) minPos = i;
  }
  
  return arr[minPos].val;
};


Array.prototype.max = function(projection) {
  if(this.length == 0) return null;
  
  if(typeof(projection) == 'undefined') projection = a => a;
  
  var arr = this.select( (a,i,it) => ({"val":a, "key": Array._createStdKey(a,i,it,projection) }));
  var minPos = 0;
  for(var i=1; i<arr.length; i++) {
    if(Array._stdLinqCompare(arr[minPos].key, arr[i].key) < 0) minPos = i;
  }
  
  return arr[minPos].val;
};


Array.prototype.count = function(predicate) {
  
  if(typeof(predicate)=='undefined') return this.length;
  
  
  var cnt = 0;
  this.each(a => {
    if(predicate(a)) cnt++;
  });
  
  return cnt;
};



Array.prototype.contains = function(val, isEqual) {
  
  if(typeof(isEqual) == 'undefined') return this.indexOf(val) != -1;
  
  for(var i=0; i<this.length; i++) {
    if(isEqual(this[i], val)) return true;
  }
  
  return false;
};

Array.prototype.all = function(predicate) {
  var val = true;
  this.each(a=> val = val && predicate(a) );
  return Array.Lazer(()=> val==true);
};

Array.prototype.any = function(predicate) {
  var val = false;
  this.each(a=> val = val || predicate(a) );
  return Array.Lazer(()=> val==true);
};




Array.prototype.pieces = function(piece_item_count) {
  var glist = this.groupBy( (a,i) => parseInt(i / piece_item_count) );
  return glist.select( a => a.list );
};



Array.prototype.skip = function(count) {
  if(count > this.length) {
    throw String.format('index overflow with value {0}', count);
  }
 
  return this.where((a,i,th)=> ( i >= count ) );
};


Array.prototype.take = function(start, count) {
  if(start + count > this.length) {
    throw String.format('index overflow with value {0}', count);
  }
  
  var arr=[];
  for(var i=0;i<count&&start+i<this.length;i++)
    arr.push(this[start+i]);
    
  return arr;
};



Array.prototype.reverseAsCopy = function() {
  var arr = [];
  for(var i=this.length-1; i>=0; i--) {
    arr.push(this[i]);
  }
  
  return arr;
};




Array.prototype.intersect = function(another, equalCallback) {
  var arr = [];
  
  if(typeof(equalCallback) == 'undefined') equalCallback = (a,b)=>a==b;
  this.each(a=>{
    //alert(another.contains(a, equalCallback)+JSON.stringify(a));
    if(this.contains(a, equalCallback) && another.contains(a, equalCallback)) arr.push(a);
  });
  
  return arr;
};


Array.prototype.union = function(another, equalCallback) {
  var arr = this.take(0, this.length);
  
  if(typeof(equalCallback) == 'undefined') equalCallback = (a,b)=>a==b;
  
  another.each(a=>{
    if(!arr.contains(a, equalCallback)) arr.push(a);
  });
  
  return arr;
};



