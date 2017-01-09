import org.apache.spark.rdd.RDD

class JoinTableTest extends SparkTestCase{
    test("should be able to merge two tables according to the need"){
        val nationTable: RDD[String] = sc.parallelize(List("0,ALGERIA,0,haggle."))
        val regionTable: RDD[String] = sc.parallelize(List("0,AFRICA,regular deposits."))
        val tableMerger: TableMerger = new TableMerger(nationTable,regionTable)
        val newTable: RDD[String] = tableMerger.merge(0,2)


        assert(newTable.collect().head=="0,ALGERIA,haggle.,AFRICA,regular deposits.")
    }
}
