using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Payment;

namespace PaymentSystemTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void CalculateFuturePaymentDate_InputCausesSundayDate_DateReturnedIsMonday()
        {
            //arrange phase
            var pd = new PaymentDates();
            DateTime sampleDate = DateTime.Parse("3/4/2020");

            //act phase
            DateTime resultDateWhichShouldBeMonday = pd.CalculateFuturePaymentDate(sampleDate);

            //assert phase
            Assert.AreEqual(DayOfWeek.Monday, resultDateWhichShouldBeMonday.DayOfWeek);
        }

        [TestMethod]
        public void CalculateFuturePaymentDate_InputCausesSaturdayOrSundayDate_DateReturned30DaysInFuture()
        {
            //arrange phase
            var pd = new PaymentDates();
            DateTime sampleDate = DateTime.Parse("30/4/2020");

            //act phase
            DateTime resultDateWhichShouldBe30DayLater = pd.CalculateFuturePaymentDate(sampleDate);

            DayOfWeek date = sampleDate.AddDays(30).DayOfWeek;
            int addDay = 0;
            if (date.Equals(DayOfWeek.Saturday))
            {
                addDay += 2;
            }else if (date.Equals(DayOfWeek.Sunday))
            {
                addDay++;
            }
            //assert phase
            Assert.AreEqual(sampleDate.AddDays(30 + addDay), resultDateWhichShouldBe30DayLater);
        }
    }
}
