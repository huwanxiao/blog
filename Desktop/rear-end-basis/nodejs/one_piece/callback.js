let fun = function (f) {
  let s = 1
  f(s)
}

fun(function (d) {
    console.log(d);
})