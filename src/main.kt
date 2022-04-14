

fun main(){
    var myBalance=CurrentAccount("40002096","Ninah",123.5)
    myBalance.deposit(55.50)
    myBalance.withdraw(50.5)
    myBalance.details()

    var mybalance=SavingsAccount("40002096","suu",890.05,500)
    myBalance.deposit(230.50)
   myBalance.withdraw(150.50)
    println( mybalance.withdrawals)
   myBalance.details()

    var a=Product("geisha",0.8,125.60,"hygiene")
    var b=Product("detol",23.7,350.5,"hygiene")
    var c=Product("book",2.6,65.5,"other")
    var d=Product("Kiwi",1.5,300.0,"groceries")
    Products(a)
    Products(b)
    Products(c)
    Products(d)




}
open class CurrentAccount(var accountNumber:String,var accountName:String,var balance:Double){
    fun deposit(amount:Double){
        balance+=amount
        println(balance)
    }
    open fun withdraw(amount: Double){
        balance-=amount
        println(balance)
    }
    fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }

}
class SavingsAccount(accountNumber: String,accountName: String,balance: Double, var withdrawals:Int):CurrentAccount(accountNumber,accountName,balance){
    override fun withdraw(amount: Double) {
        if (withdrawals<2){
            balance-=amount
        }
        println(balance)
        withdrawals++
    }

}

data class Product(var name:String, var weight:Double,var price:Double,var category:String)
fun Products(product:Product){

    var groceries= mutableListOf<Product>()
    var hygiene= mutableListOf<Product>()
    var other= mutableListOf<Product>()
    when(product.category){
        "groceries"-> groceries.add(product)
        "hygiene"->hygiene.add(product)
        "other"->other.add(product)
    }
    println( listOf(product))

}
